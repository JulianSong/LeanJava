package lean;

import lean.basic.LeanString;
import lean.io.LeanIO;
import lean.network.LeanNetwork;
import lean.sql.LeanDatabase;
import lean.swing.LeanSwing;
import lean.thread.LeanThread;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("please input the command!");
        String command;
        do {
            command = bf.readLine();
            doCommand(command);
        } while (!command.equals("exit"));
    }

    public static void doCommand(String cmd) throws Exception {
        switch (cmd) {
            case "stringArray":
                LeanString.stringArray();
                break;
            case "subString":
                LeanString.subString();
                break;
            case "inputStreamRead":
                LeanIO.inputStreamRead();
                break;
            case "vector":
                LeanIO.vector();
                break;
            case "classTest":
                LeanIO.classTest();
                break;
            case "createFile":
                LeanIO.createFile();
                break;
            case "listProjectItems":
                LeanIO.listProjectItems(null, 0);
                break;
            case "fileReader":
                LeanIO.fileReader();
                break;
            case "fileSteam":
                LeanIO.fileSteam();
                break;
            case "fileCopy":
                LeanIO.fileCopy();
                break;
            case "runThread":
                LeanThread.runThread();
                break;
            case "runCallable":
                LeanThread.runCallable();
                break;
            case "runSync":
                LeanThread.runSync();
                break;
            case "testSql":
                LeanDatabase.testSql();
                break;
            case "testURLConnection":
                LeanNetwork.testURLConnection();
                break;
            case "testURLConnectionPost":
                LeanNetwork.testURLConnectionPost();
                break;
            case "leanSwing":
                LeanSwing.leanSwing();
                break;
        }
    }
}
