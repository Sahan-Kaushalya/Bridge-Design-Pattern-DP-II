package lk.kaushalya.model;


interface OS {
    public void launchApp();

    public void closeApp();
}

abstract class App {

    protected OS os;

    public App(OS os) {
        this.os = os;
    }

    public abstract void run();

    public abstract void exit();
}

class WindowsOS implements OS {

    @Override
    public void launchApp() {
        System.out.println("Windows OS: App launched successfully");
    }

    @Override
    public void closeApp() {
        System.out.println("Windows OS: App closed successfully");
    }
}

class MacOS implements OS {

    @Override
    public void launchApp() {
        System.out.println("Windows OS: App launched successfully");
    }

    @Override
    public void closeApp() {
        System.out.println("Windows OS: App closed successfully");
    }
}

class TextEditor extends App {

    public TextEditor(OS os) {
        super(os);
    }

    @Override
    public void run() {
        System.out.println("Text Editor is running.......");
        os.launchApp();
    }

    @Override
    public void exit() {
        System.out.println("Text Editor is closing.......");
        os.closeApp();
    }
}

class MediaPlayer extends App {

    public MediaPlayer(OS os) {
        super(os);
    }

    @Override
    public void run() {
        System.out.println("Media Player is running.......");
        os.launchApp();
    }

    @Override
    public void exit() {
        System.out.println("Media Player is closing.......");
        os.closeApp();
    }
}


public class Test {
    public static void main(String[] args) {
        OS windowsOS = new WindowsOS();
        OS macOS = new MacOS();

        System.out.println();

        App textEditorOnWindows = new TextEditor(windowsOS);
        textEditorOnWindows.run();
        textEditorOnWindows.exit();

        System.out.println();

        App mediaPlayerOnMac = new MediaPlayer(macOS);
        mediaPlayerOnMac.run();
        mediaPlayerOnMac.exit();
    }
}