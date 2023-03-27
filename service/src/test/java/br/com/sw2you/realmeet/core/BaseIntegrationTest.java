package br.com.sw2you.realmeet.core;

import static br.com.sw2you.realmeet.utils.TestConstants.TEST_CLIENT_API_KEY;
import static br.com.sw2you.realmeet.utils.TestConstants.TEST_CLIENT_DESCRIPTION;
import static org.mockito.BDDMockito.given;

import br.com.sw2you.realmeet.Application;
import br.com.sw2you.realmeet.api.ApiClient;

import java.net.MalformedURLException;
import java.net.URL;

import com.sun.activation.registries.MailcapParseException;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

// pro spring saber que deve ler as informações do aplication-integration-test
@ActiveProfiles(profiles = "integration-test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Application.class)
public abstract class BaseIntegrationTest {

    @Autowired
    private Flyway flyway;

    //spring injeta o valor da porta handomica
    @LocalServerPort
    private int serverPort;

    @BeforeEach
    void setup() throws Exception {
         setupFlyway();
         setupEach();
    }

    protected void setupEach()   throws Exception{}
    //contexto do servidor
    protected void setLocalHostBasePath(ApiClient apiClient,String path) throws  MalformedURLException {
        apiClient.setBasePath(new URL("http", "localhost", serverPort, path).toString());
    }

    private void setupFlyway(){
        flyway.clean();
        flyway.migrate();
    }

}
