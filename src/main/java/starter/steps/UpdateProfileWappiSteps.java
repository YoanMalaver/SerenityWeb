package starter.steps;


import net.serenitybdd.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import starter.interacciones.GeneralInteraction;
import starter.mapeos.wappi.MainWappiPage;
import starter.mapeos.wappi.ProfileInformationWappiPage;
import starter.models.ProfileModel;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static starter.Utils.PathDownloadsFiles.getDefaultDownloadDirectory;

public class UpdateProfileWappiSteps {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpdateProfileWappiSteps.class);
    private static final String RUTA_BASE_IMAGEN = getDefaultDownloadDirectory();

    @Page
    private ProfileInformationWappiPage profileInformationWappiPage;

    @Page
    private MainWappiPage mainWappiPage;

    @Page
    private GeneralInteraction generalInteraction;

    @Step("se carga la información actualizada del perfil")
    public void updateInformation(ProfileModel profileModel) {
        System.out.println(RUTA_BASE_IMAGEN);
        final Path rutaImagen = Paths.get(RUTA_BASE_IMAGEN.concat("modelo de BD.png")).toAbsolutePath();
        System.out.println(rutaImagen);
        LOGGER.info("Se registra la información del usuario");
        LOGGER.info("Ruta del archivo:{}", rutaImagen);
//      profileInformationWappiPage.upload(rutaImagen.toString()).to(profileInformationWappiPage.inputImage);//Forma en que lo hace Serenity BDD(es lo ideal), utilizarla si funciona para tu pagina de prueba.
        generalInteraction.uploadFile(profileInformationWappiPage.inputImage, rutaImagen.toString());
        profileInformationWappiPage.txtName.type(profileModel.getNombre());
        profileInformationWappiPage.txtLastName.type(profileModel.getApellido());
        profileInformationWappiPage.txtBornDate.type(profileModel.getFechaNacimiento());
        profileInformationWappiPage.getElementGender(profileModel.getGenero()).click();
        profileInformationWappiPage.countryDropdown.selectByVisibleText(profileModel.getPais());
        profileInformationWappiPage.btnSaveInformationProfile.click();

    }

    @Step("Ir al formulario de actualización de perfil")
    public void goToUpdateProfileForm() {
        mainWappiPage.menuOptionUpdateProfile.waitUntilClickable().click();
        profileInformationWappiPage.txtName.waitUntilVisible();
    }

    @Step("La actualización se realizó correctamente")
    public void validarActualizacion(List<String> expectedMessages) {
        assertThat("La actualización ha fallado", profileInformationWappiPage.txtUpdateResult.waitUntilVisible().getText(),
                is(equalTo(expectedMessages.get(0))));
    }

}
