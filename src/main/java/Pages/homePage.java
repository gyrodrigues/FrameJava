package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Utils.Base;

public class homePage extends Base {
	
	public void acessarUrl(String url) {
		
		acessar(url);
	}

	public void realizarbusca(String produto) {
		
		escreve(By.id("h_search-input"), produto);
		clicarBotao("h_search-btn");
		
	}

	public void validarbuscadeproduto(String produto) {
	
		//*[@class='row product-grid no-gutters main-grid']/div[1]//h2,
		elementPresent(By.xpath("//*[@class='row product-grid no-gutters main-grid']/div[1]//h2"));
		String nameproduto = obterTexto(By.xpath("//*[@class='row product-grid no-gutters main-grid']/div[1]//h2")).toLowerCase();
		if(!nameproduto.contains(produto.toLowerCase())) {
			Assert.fail("O resultado não correspondeu a pesquisa.");
		}
		
	}

	public String clicarnoProduto(String produto) {
		
		
		elementPresent(By.xpath("//*[@class='row product-grid no-gutters main-grid']/div[1]//h2"));

		WebElement elem  = elemento(By.xpath("//*[@class='row product-grid no-gutters main-grid']/div[1]//h2"));
		if (elem.getText().toLowerCase().contains(produto.toLowerCase())) {
			
			String txt = elem.getText();
			elem.click();
			return txt;
			
		}
		else
		{
			Assert.fail("Produto informado não localizado");
			return "";
		}
		
	}

}
