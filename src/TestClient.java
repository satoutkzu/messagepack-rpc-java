import org.msgpack.rpc.Client;
import org.msgpack.rpc.loop.EventLoop;

public class TestClient {
    public static interface RPCInterface {
        String hello(String msg, int a);
    }

    public static void main(String[] args) throws Exception {
        EventLoop loop = EventLoop.defaultEventLoop();

        Client cli = new Client("localhost", 20001, loop);
        RPCInterface iface = cli.proxy(RPCInterface.class);

        System.out.println(iface.hello("hello", 1));
        loop.shutdown();
    }
}