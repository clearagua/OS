public class Process {

    private int PID;
    private int arrivalTime;
    private int serviceTime;
    private int priority;

    Process(int PID, int arrivalTime, int serviceTime, int priority) {
        this.PID = PID;
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
        this.priority = priority;
    }

    public int getPriority() {
        return this.priority;
    }

    public int getArrivalTime() {
        return this.arrivalTime;
    }

    public int getServiceTime() {
        return this.serviceTime;
    }

    public void decrementServiceTime() {
        this.serviceTime--;
    }

    public int getPID() {
        return this.PID;
    }
}
