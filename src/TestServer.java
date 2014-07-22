import org.msgpack.rpc.Server;
import org.msgpack.rpc.loop.EventLoop;

public class TestServer {
    public String hello(String msg, int a) {
        return msg + ", takanori!";
    }

    public static void main(String[] args) throws Exception {
        EventLoop loop = EventLoop.defaultEventLoop();

        Server svr = new Server();
        svr.serve(new TestServer());
        svr.listen(20001);

        loop.join();
    }
}