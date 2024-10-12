import netware.client.RequestClient;
import netware.client.callbacks.ClientCallback;
import netware.client.holders.RequestError;
import netware.client.holders.RequestResponse;
import org.jetbrains.annotations.NotNull;

public class NetworkRequestWithCallback {

    public static void main(String[] args) {

        new RequestClient(
                "http://localhost:8000/hello-world/ss"
        ).build(new ClientCallback() {
            @Override
            public void onSuccess(@NotNull RequestResponse response) {
                System.out.println(response.getResponseLog(
                        true
                ));
            }

            @Override
            public void onError(@NotNull RequestError error) {
                System.out.println(error.getErrorLog(
                        true
                ));
            }
        });
    }
}
