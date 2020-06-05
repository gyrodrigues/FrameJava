package Pages;

import org.openqa.selenium.By;

import Utils.Base;

public class produtoPage extends Base {
	
	public void addCarrinho() {
		elementPresent(By.xpath("//*[@id='btn-buy']/div/span"));
		clicarBotao(By.xpath("//*[@id='btn-buy']/div/span"));
	}

}
