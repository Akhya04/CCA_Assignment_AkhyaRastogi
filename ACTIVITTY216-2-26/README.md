# Real-Time Practice Problem
## Banking Transaction Logging System
### Problem Title:Secure Banking Log Manager

This contains:
LogEntry
ActionType
SuspiciousDetector
LogManager
Main

1. ActionType Enum:
package banking;
public enum ActionType {
    DEPOSIT,
    WITHDRAW,
    TRANSFER,
    LOGIN,
    FAILED_LOGIN
}

2.Status Enum:
package banking;
public enum Status {
    SUCCESS,
    FAILED
}

3.LogEntry Model Class:
package banking;
import java.time.LocalDateTime;
public class LogEntry {
    private static int counter = 1;
    private int logId;
    private String accountNumber;
    private ActionType actionType;
    private double amount;
    private LocalDateTime timestamp;
    private Status status;
    public LogEntry(String accountNumber, ActionType actionType, double amount, Status status) {
        this.logId = counter++;
        this.accountNumber = accountNumber;
        this.actionType = actionType;
        this.amount = amount;
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }
    public int getLogId() { return logId; }
    public String getAccountNumber() { return accountNumber; }
    public ActionType getActionType() { return actionType; }
    public double getAmount() { return amount; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public Status getStatus() { return status; }
    @Override
    public String toString() {
        return "LogID=" + logId +
                ", Acc=" + accountNumber +
                ", Action=" + actionType +
                ", Amount=" + amount +
                ", Status=" + status +
                ", Time=" + timestamp;
    }
}


4.SuspiciousDetector:
package banking;
import java.util.List;
public interface SuspiciousDetector {
    List<LogEntry> detectSuspicious();
}

5.LogManager:
package banking;
import java.util.*;
public class LogManager implements SuspiciousDetector {
    private List<LogEntry> allLogs = new ArrayList<>();
    private Map<String, List<LogEntry>> accountLogs = new HashMap<>();
    private Map<ActionType, List<LogEntry>> actionLogs = new HashMap<>();
    public void addLog(LogEntry log) {
        allLogs.add(log);
        accountLogs.putIfAbsent(log.getAccountNumber(), new ArrayList<>());
        accountLogs.get(log.getAccountNumber()).add(log);
        actionLogs.putIfAbsent(log.getActionType(), new ArrayList<>());
        actionLogs.get(log.getActionType()).add(log);
    }
    public List<LogEntry> getLogsByAccount(String accountNumber) {
        return accountLogs.getOrDefault(accountNumber, new ArrayList<>());
    }
    public List<LogEntry> getRecentLogs(int n) {
        List<LogEntry> result = new ArrayList<>();
        int start = Math.max(0, allLogs.size() - n);
        for (int i = allLogs.size() - 1; i >= start; i--) {
            result.add(allLogs.get(i));
        }
        return result;
    }
    public List<LogEntry> searchByAction(ActionType type) {
        return actionLogs.getOrDefault(type, new ArrayList<>());
    }
    @Override
    public List<LogEntry> detectSuspicious() {
        List<LogEntry> suspicious = new ArrayList<>();
        for (String acc : accountLogs.keySet()) {
            List<LogEntry> logs = accountLogs.get(acc);
            for (int i = 0; i < logs.size(); i++) {
                LogEntry log = logs.get(i);
                if (log.getActionType() == ActionType.WITHDRAW &&
                        log.getAmount() > 50000)
                    suspicious.add(log);
                if (i >= 4) {
                    int failed = 0;
                    for (int j = i - 4; j <= i; j++) {
                        if (logs.get(j).getActionType() ==
                                ActionType.FAILED_LOGIN)
                            failed++;
                    }
                    if (failed > 3)
                        suspicious.add(log);
                }
            }
        }
        return suspicious;
    }
}

6.Main Driver:
package banking;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LogManager manager = new LogManager();
        while (true) {
            System.out.println("\n1.Add Log");
            System.out.println("2.Get Logs by Account");
            System.out.println("3.Get Recent Logs");
            System.out.println("4.Detect Suspicious Activity");
            System.out.println("5.Search by Action");
            System.out.println("6.Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Account: ");
                    String acc = sc.next();
                    System.out.print("Action: ");
                    ActionType type =
                            ActionType.valueOf(sc.next());
                    System.out.print("Amount: ");
                    double amt = sc.nextDouble();
                    System.out.print("Status: ");
                    Status st =
                            Status.valueOf(sc.next());
                    manager.addLog(
                            new LogEntry(acc, type, amt, st));
                    break;
                case 2:
                    manager.getLogsByAccount(sc.next())
                            .forEach(System.out::println);
                    break;
                case 3:
                    manager.getRecentLogs(sc.nextInt())
                            .forEach(System.out::println);
                    break;
                case 4:
                    manager.detectSuspicious()
                            .forEach(System.out::println);
                    break;
                case 5:
                    manager.searchByAction(
                            ActionType.valueOf(sc.next()))
                            .forEach(System.out::println);
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }
}
