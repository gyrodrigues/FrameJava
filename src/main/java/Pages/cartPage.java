package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;

import Utils.Base;

public class cartPage extends Base{
	
	public void validarProduto(String produto) {
		elementPresent(By.xpath("//*[@class='container-fluid']//span[@class='TextUI-sc-12tokcy-0 iwCUMn']"));
		String nameproduto = obterTexto(By.xpath("//*[@class='container-fluid']//span[@class='TextUI-sc-12tokcy-0 iwCUMn']")).toLowerCase();
		Assert.assertEquals(nameproduto, produto.toLowerCase());
	}

}
