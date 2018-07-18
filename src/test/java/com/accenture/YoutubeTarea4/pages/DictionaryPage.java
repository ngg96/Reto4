package com.accenture.YoutubeTarea4.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.stream.Collectors;

import net.serenitybdd.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;

import java.util.ArrayList;
import java.util.List;

@DefaultUrl("https://www.youtube.com/watch?v=V15BYnSr0P8")
public class DictionaryPage extends PageObject {

    @FindBy(xpath="//*[@id=\"top-level-buttons\"]/ytd-button-renderer[1]/a")
    private WebElementFacade share;

    @FindBy(xpath="//button[@title='Facebook']")
    private WebElementFacade facebook;
    
    @FindBy(xpath="//*[@id=\"email\"]")
    private WebElementFacade fbEmail;
    
    @FindBy(xpath="//*[@id=\"pass\"]")
    private WebElementFacade fbPass;
    
    @FindBy(xpath="//*[@id=\"u_0_1w\"]")
    private WebElementFacade fbPublic;
  
    public void Share() {
        share.click();
    }

    public void lookup_terms() {
        facebook.click();
        
        ArrayList<String> newTab = new ArrayList<String>(getDriver().getWindowHandles());

    	// Cierro la actual
    	getDriver().close();

    	// newTab.remove(oldTab);

    	// Cambio a la ultima pestaña
    	getDriver().switchTo().window(newTab.get(newTab.size() - 1));
    }
    
    public void email(String email) {
    	fbEmail.type(email);
    }
    
    public void pass(String pass) { 
    	fbPass.type(pass+"\n");
    }
    
    public void publicar() {
    	fbPublic.click();
    }
    
    public List<String> getDefinitions() {
        WebElementFacade definitionList = find(By.tagName("ol"));
        return definitionList.findElements(By.tagName("li")).stream()
                             .map( element -> element.getText() )
                             .collect(Collectors.toList());
    }
}