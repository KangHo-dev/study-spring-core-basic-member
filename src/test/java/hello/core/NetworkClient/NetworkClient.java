package hello.core.NetworkClient;
/**
 * InitializingBean : 의존관계 주입 후에 호출
 * DisposableBean : 빈이 종료될 때 호출
 *
 * -> 인터페이스를 사용하는 초기화,종료 방법은 스프링 초기(2003년)에 나온 방법 / 지금은 더 나은 방법들이 사용되기 때문에
 * 거의 쓰이지 않음
 */

public class NetworkClient {
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);

    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작시 호출
    public void connect() {
        System.out.println("connect: " + url);
    }

    public void call(String message) {
        System.out.println("call: " + url + " message = " + message);
    }

    //서비스 종료시 호출
    public void disconnect() {
        System.out.println("close: " + url);
    }

    public void init() throws Exception {
        connect();
        call("초기화 연결 메시지");
    }

    public void close() throws Exception {
        System.out.println("NetworkClient.destroy");
        disconnect();
    }
}
