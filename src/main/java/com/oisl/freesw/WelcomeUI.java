package com.oisl.freesw;

import com.vaadin.annotations.Theme;
import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Created by julien on 9/30/16.
 */
@SpringUI
@Theme("mytheme")
public class WelcomeUI extends UI {

    private VerticalLayout container;
    private VerticalLayout holderLayout;
    private Panel envelope;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setupBasket();
        setHeader();
        setAccessLayout();
        addButtonSet();
        addCopyrights();

    }

    private void setupBasket() {
        holderLayout = new VerticalLayout();
        holderLayout.setSizeFull();
        holderLayout.setSpacing(true);
        holderLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        envelope = new Panel(holderLayout);
        envelope.setWidth(null);
        container = new VerticalLayout();
        container.addComponent(envelope);
        container.setSizeFull();
        container.setComponentAlignment(envelope, Alignment.MIDDLE_CENTER);
        Label headerTitle = new Label("<b>Welcome To The Church Asset Register!</b>", ContentMode.HTML);
        headerTitle.setStyleName(ValoTheme.LABEL_H1);
        headerTitle.setSizeUndefined();
        holderLayout.addComponent(headerTitle);
        envelope.setContent(holderLayout);
        setContent(container);
    }

    private void setHeader() {
        VerticalLayout header = new VerticalLayout();
        header.setSpacing(true);
        header.setMargin(new MarginInfo(false, false, false, false));
        //header.setSizeFull();
        header.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        Resource srcImage = new ThemeResource("img/sda_logo_03.png");
        Image logo = new Image(null, srcImage);
        logo.setSizeUndefined();
        Label appName = new Label("<b>Church Digital Asset Register</b>", ContentMode.HTML);
        appName.setStyleName(ValoTheme.LABEL_H3);
        appName.setSizeUndefined();
        Label disclaimer = new Label("<b><i>Be warned that this is a private application, if you are not a registered user, don't attempt...</i></b>", ContentMode.HTML);
        disclaimer.addStyleName(ValoTheme.LABEL_COLORED);
        disclaimer.setSizeUndefined();
        header.addComponents(logo, appName, disclaimer);
        holderLayout.addComponents(header);
    }

    private void setAccessLayout() {
        VerticalLayout accessLayout = new VerticalLayout();
        accessLayout.setSpacing(true);
        accessLayout.setMargin(new MarginInfo(true, false, false, false));
        //accessLayout.setSizeFull();
        accessLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        Button signIn = new Button("Login");
        signIn.setStyleName(ValoTheme.BUTTON_LINK);
        Label toRegister = new Label("If not registered...");
        toRegister.setStyleName(ValoTheme.LABEL_H2);
        toRegister.setSizeUndefined();
        Button signUp = new Button("Sign Up");
        signUp.setStyleName(ValoTheme.BUTTON_LINK);
        accessLayout.addComponents(signIn, toRegister, signUp);
        holderLayout.addComponent(accessLayout);
    }

    private void addButtonSet() {
        HorizontalLayout btnHolder = new HorizontalLayout();
        btnHolder.setSpacing(true);
        btnHolder.setWidth("30%");
        btnHolder.setMargin(new MarginInfo(true, false, true, false));
        Button btnContinue = new Button("Continue");
        btnContinue.setStyleName(ValoTheme.BUTTON_PRIMARY);
        Button btnCancel = new Button("Exit");
        btnCancel.setStyleName(ValoTheme.BUTTON_DANGER);
        btnHolder.addComponents(btnCancel, btnContinue);
        btnHolder.setComponentAlignment(btnContinue, Alignment.MIDDLE_RIGHT);
        btnHolder.setComponentAlignment(btnCancel, Alignment.MIDDLE_LEFT);
        holderLayout.addComponent(btnHolder);
    }

    private void addCopyrights() {
        HorizontalLayout footer = new HorizontalLayout();
        footer.setWidth("50%");
        footer.setMargin(new MarginInfo(true, false, false, false));
        Label copyrights = new Label("<i>Designed by OKAPI ICT Solutions&reg</i>");
        copyrights.setContentMode(ContentMode.HTML);
        copyrights.setStyleName(ValoTheme.LABEL_TINY);
        copyrights.setSizeUndefined();
        footer.addComponent(copyrights);
        footer.setComponentAlignment(copyrights, Alignment.BOTTOM_CENTER);
        holderLayout.addComponent(footer);
        holderLayout.setComponentAlignment(footer, Alignment.BOTTOM_CENTER);
    }
}
