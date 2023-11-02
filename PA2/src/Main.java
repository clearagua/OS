import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<Process> readFile(String fileName) throws IOException {
        List<Process> processes = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        String[] values;
        int PID = 1;
        while ((line = reader.readLine()) != null) {
            values = line.split(" ");
            processes.add(new Process(PID, Integer.parseInt(values[0]), Integer.parseInt(values[1]), Integer.parseInt(values[2])));
            PID++;
        }
        return processes;
    }

    private static void execute(List<Process> processes) throws InterruptedException {
        PriorityQueue queue = new PriorityQueue(processes.size());
        int timer = 0;
        while (true) {
            // inserting processes into the priority queue as they arrive
            if (!processes.isEmpty() &&timer == processes.get(0).getArrivalTime()) {
                queue.insert(processes.remove(0));
            }
            execute(queue);

            if (queue.isEmpty()) {
                break;
            }

            timer++;
            Thread.sleep(250);
        }
        System.out.println("Processes Finished");
    }

    private static void execute(PriorityQueue queue) {
        Process runningProcess = queue.remove();
        runningProcess.decrementServiceTime();
        System.out.println("Process " + runningProcess.getPID() + " Running, Remaining Service Time: " + runningProcess.getServiceTime());
        if (runningProcess.getServiceTime() > 0) {
            queue.insert(runningProcess);
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        List<Process> processes = readFile("src/input.txt");
        execute(processes);
    }
}