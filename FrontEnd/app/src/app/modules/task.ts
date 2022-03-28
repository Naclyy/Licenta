export interface Task{
    taskId: number;
    userId: number,
    whatObjectives: string | null;
    howObjectives: string | null;
    dateAdded: string,
    deadLine: string
}
