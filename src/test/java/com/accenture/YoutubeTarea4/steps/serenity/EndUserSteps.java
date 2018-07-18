package com.accenture.YoutubeTarea4.steps.serenity;

import com.accenture.YoutubeTarea4.pages.DictionaryPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class EndUserSteps {

    DictionaryPage dictionaryPage;

    @Step
    public void share(String email, String pass) {
 
    	dictionaryPage.email(email);
    	dictionaryPage.pass(pass);
    	dictionaryPage.publicar();
    }
    
    	@Step
    public void starts_search() throws InterruptedException {
        dictionaryPage.Share();
        Thread.sleep(5000);
        dictionaryPage.lookup_terms();
    }

    @Step
    public void should_see_definition(String definition) {
        assertThat(dictionaryPage.getDefinitions(), hasItem(containsString(definition)));
    }

    @Step
    public void is_the_home_page() {
        dictionaryPage.open();
    }

    @Step
    public void looks_for(String term) throws InterruptedException {
        starts_search();
    }
}