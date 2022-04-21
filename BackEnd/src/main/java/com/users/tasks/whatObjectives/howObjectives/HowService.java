package com.users.tasks.whatObjectives.howObjectives;
import com.pert.PertNodes;
import com.users.UserInformation;
import com.users.UserInformationRepository;
import com.users.tasks.whatObjectives.howObjectives.predecessors.PredecessorsInformation;
import com.users.tasks.whatObjectives.howObjectives.predecessors.PredecessorsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;


@Service
@Transactional
@AllArgsConstructor
public class HowService {
    private final HowRepository howRepository;
    private final UserInformationRepository userInformationRepository;
    private final PredecessorsRepository predecessorsRepository;
    public HowInformation addNewTask(HowInformation howInformation){
        howRepository.save(howInformation);
        return howInformation;
    }
    public void addPredecessor(Long predecessor, Long howId){
        predecessorsRepository.save(new PredecessorsInformation(howId, predecessor));
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
    }
    public List<Graph> CalculateGraph(Long what_id){
        List<HowInformation> nodesFromRepo = howRepository.findAllByWhatId(what_id);
        List<PertNodes> nodes = new LinkedList<>();
        nodes.add(new PertNodes(0, 0, 0, 0, 0));
        for(int i = 1; i <= nodesFromRepo.size(); i++){
            nodes.add(new PertNodes(nodesFromRepo.get(i - 1).getEstimatedTime()));
        }
        for(int i = 1; i <= nodesFromRepo.size(); i++){
            UserInformation user = userInformationRepository.findUserInformationByUserId(nodesFromRepo.get(i - 1).getUserId());
            nodes.get(i).setName(user.getFirstName() + " " + user.getLastName());
            if(nodesFromRepo.get(i - 1).getPredecessorsInformationList().isEmpty()){
                nodes.get(i).addPredecessors(nodes.get(0));
            }
            else {
                for (PredecessorsInformation predecessor : nodesFromRepo.get(i - 1).getPredecessorsInformationList()) {
                    nodes.get(i).addPredecessors(nodes.get(Math.toIntExact(predecessor.getPredecessorId())));
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
