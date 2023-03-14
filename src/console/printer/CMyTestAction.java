package console.printer;

import com.intellij.execution.ui.ConsoleView;
import com.intellij.execution.ui.ConsoleViewContentType;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

import java.util.Objects;

public class CMyTestAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here
        ConsoleView consoleView = Objects.requireNonNull(ConsolePrinterToolWindow.myConsoleView);
        for (int i = 0; i < 1000; i++) {
            consoleView.print("\n测试时间：" + System.currentTimeMillis(), ConsoleViewContentType.LOG_INFO_OUTPUT);
        }

    }
}
