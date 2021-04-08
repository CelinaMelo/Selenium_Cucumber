package suite;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import componentesTest.CadastroCompletoTest;
import parametrizacao.RegraCadastroParametrizadoTest;
import util.DriverFactory;

@RunWith(Suite.class)
@SuiteClasses({
	CadastroCompletoTest.class,
	RegraCadastroParametrizadoTest.class
	})

public class SuiteTestes {	

	@AfterClass
	public static void fechar() {
		DriverFactory.killDriver();
	}
}
