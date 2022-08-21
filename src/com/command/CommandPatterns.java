package com.command;

/**
 * 命令模式
 */
public class CommandPatterns {
    public static void main(String[] args) {
        Command command = new SaveCommand();
        Invoker invoker = new Invoker(command);
        invoker.execute();

        command = new DelCommand();
        invoker = new Invoker(command);
        invoker.execute();
    }
}

/**
 * 命令接口
 */
interface Command{
    void execute();
}

/**
 * 打印命令
 */
class SaveCommand implements Command{
    ReceiverSave receiver = new ReceiverSave();
    @Override
    public void execute() {
        receiver.save();
    }
}

/**
 * 其他命令
 */
class DelCommand implements Command{
    ReceiverDel receiver = new ReceiverDel();
    @Override
    public void execute() {
        receiver.del();
    }
}

/**
 * 命令接收者-保存
 */
class ReceiverSave{
    public void save(){
        System.out.println("命令接收者 保存");
    }
}
/**
 * 命令接收者-删除
 */
class ReceiverDel{
    public void del(){
        System.out.println("命令接收者 删除");
    }
}

/**
 * 命令发送者
 */
class Invoker{
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void execute(){
        command.execute();
    }
}