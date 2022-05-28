package com.services;
import com.pert.PertNodes;
import com.entities.UserInformation;
import com.dao.UserInformationRepository;
import com.entities.dto.Graph;
import com.entities.HowInformation;
import com.dao.HowRepository;
import com.entities.PredecessorsInformation;
import com.dao.PredecessorsRepository;
import com.entities.JoinTableInformation;
import com.dao.JoinTableRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;


@Service
@Transactional
@AllArgsConstructor
public class HowService {
    private final HowRepository howRepository;
    private final UserInformationRepository userInformationRepository;
    private final PredecessorsRepository predecessorsRepository;
    private final JoinTableRepository joinTableRepository;
    public HowInformation addNewTask(HowInformation howInformation){
        JoinTableInformation hasWhatTask = new JoinTableInformation(howInformation.getUserId(), howInformation.getWhatId());
        if(joinTableRepository.findJoinTableInformationByWhatIdAndUserId(howInformation.getUserId(), howInformation.getWhatId())==null){
               joinTableRepository.save(hasWhatTask);
        }
        howRepository.save(howInformation);
        return howInformation;
    }
    public void addPredecessor(Long predecessor) throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        predecessorsRepository.save(new PredecessorsInformation(howRepository.findTopByOrderByTaskIdDesc().getTaskId(), predecessor));
    }
    public List<HowInformation> getHowObjectivesByUserId(Long id){
        return howRepository.findHowInformationByUserId(id);
    }
    public List<HowInformation> getHowObjectivesByWhatId(Long id){
        return howRepository.findHowInformationByWhatId(id);
    }
    public void deleteTask(Long taskId){
        boolean exists = howRepository.existsById(taskId);
        if (!exists) {
            throw new IllegalStateException("taskul cu id-ul" + taskId + " nu exista");
        }
        howRepository.deleteById(taskId);
        List<PredecessorsInformation> list = predecessorsRepository.findPredecessorsInformationByPredecessorId(taskId);
        if(list != null)
            for(PredecessorsInformation elem : list)
            predecessorsRepository.deleteById(elem.getId());
    }


    public List<Graph> CalculateGraph(Long what_id){
        List<HowInformation> nodesFromRepo = howRepository.findAllByWhatId(what_id);
        List<PertNodes> nodes = new LinkedList<>();
        nodes.add(new PertNodes(0, 0, 0, 0, 0, 0));
        for (HowInformation howInformation : nodesFromRepo) {
            nodes.add(new PertNodes(Math.toIntExact(howInformation.getTaskId()), howInformation.getEstimatedTime()));
        }
        for(int i = 1; i <= nodesFromRepo.size(); i++){
            UserInformation user = userInformationRepository.findUserInformationByUserId(nodesFromRepo.get(i - 1).getUserId());
            nodes.get(i).setName(user.getFirstName() + " " + user.getLastName());
            System.out.println(nodes.get(i).getName());
            if(nodesFromRepo.get(i - 1).getPredecessorsInformationList().isEmpty()){
                nodes.get(i).addPredecessors(nodes.get(0));
            }
            else {
                for (PredecessorsInformation predecessor : nodesFromRepo.get(i - 1).getPredecessorsInformationList()) {
                    for(PertNodes node : nodes) {
                        if(node.getId() == Math.toIntExact(predecessor.getPredecessorId()))
                            nodes.get(i).addPredecessors(node);
                    }
                }
            }
        }

        for(PertNodes node : nodes){
            node.calculateEarlyStartFinish();
        }
        for(int i = nodes.size() - 1; i >= 0 ; i--){
            nodes.get(i).calculateLateStartFinish();
        }
        List<Graph> graphElement = new LinkedList<>();
        for(PertNodes node : nodes) {
            if (node.getName() != null) {
                graphElement.add(new Graph(
                        node.getName(),
                        node.getEarlyStart(),
                        node.getEarlyFinish(),
                        node.getLateStart(),
                        node.getLateFinish()));
            }
        }
        System.out.println(graphElement);
        return graphElement;
    }
    public void removeByUserId(Long id){
        howRepository.removeHowInformationsByUserId(id);
    }
}
