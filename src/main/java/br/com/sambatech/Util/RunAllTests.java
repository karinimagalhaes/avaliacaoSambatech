package br.com.sambatech.Util;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.sambatech.SuiteDashboard.CadastroProjetoTest;
import br.com.sambatech.SuiteDashboard.NotificacaoTest;
import br.com.sambatech.SuiteLogin.LoginTest;
import br.com.sambatech.SuiteLogin.RecuperarSenhaTest;
import br.com.sambatech.SuiteUpload.UploadTest;

@RunWith(Suite.class)
@SuiteClasses({
	LoginTest.class,
	RecuperarSenhaTest.class,
	CadastroProjetoTest.class,
	NotificacaoTest.class,
	UploadTest.class
})


public class RunAllTests {

}
