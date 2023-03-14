package console.printer;

import com.intellij.execution.filters.TextConsoleBuilderFactory;
import com.intellij.execution.ui.ConsoleView;
import com.intellij.execution.ui.ConsoleViewContentType;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentManager;
import org.jetbrains.annotations.NotNull;

public class ConsolePrinterToolWindow implements ToolWindowFactory {
    public static ConsoleView myConsoleView;

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        ContentManager contentManager = toolWindow.getContentManager();
        myConsoleView = TextConsoleBuilderFactory.getInstance().createBuilder(project).getConsole();
        Content content = contentManager.getFactory().createContent(myConsoleView.getComponent(), "MyConsole", true);
        contentManager.addContent(content, 0);
        toolWindow.show(new Runnable() {
            @Override
            public void run() {
                myConsoleView.print("Start here", ConsoleViewContentType.LOG_INFO_OUTPUT);
            }
        });
    }
}
