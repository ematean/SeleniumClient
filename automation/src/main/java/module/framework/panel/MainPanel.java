package module.framework.panel;

/**
 * Rebuild or clean project after adding new panel or removing to generate associated files
 */
import core.helpers.Element;
import core.helpers.Helper;
import core.support.annotation.Panel;
import core.uiCore.webElement.EnhancedBy;
import data.framework.User;
import module.webApp.panel.LoginPanel;
import moduleManager.module.framework.PanelManager;

@Panel
public class MainPanel {

	// ensure the proper panel manager is imported, containing project "test.module name2".
	//eg. moduleManager.module.<test.module name2>.PanelManager
	PanelManager manager;
	public MainPanel(PanelManager manager) {
		this.manager = manager;
	}
	
	// Locators
	//--------------------------------------------------------------------------------------------------------	
	
	// using wildcard to find element
	public static EnhancedBy EDIT_BUTTON = Element.byCss(".fa-pencil", "signout option");

	public static EnhancedBy SUBMIT_BUTTON = Element.byCss("[type='submit']", "submit button");

	
	public static EnhancedBy ADMIN_LOGO = Element.byCss(".projectName", "admin logo");
	public static EnhancedBy USERINFO_DROPDOWN = Element.byCss(".fa-caret-down", "userinfo dropdown");
	public static EnhancedBy USERINFO_DROPDOWN_OPTIONS = Element.byCss("[role='menuitem']", "userinfo dropdown options");

	public static EnhancedBy SIGNOUT_OPTION = Element.byCss(".fa-sign-out", "signout option");
	
	
	// Users panel
	public static EnhancedBy USER_ROWS = Element.byCss("tr[class*='TableRow']", "user rows");	
	
	// Actions
	//--------------------------------------------------------------------------------------------------------	
	public void logout() {
		Helper.selectDropDown(USERINFO_DROPDOWN, USERINFO_DROPDOWN_OPTIONS, "Logout");
		Helper.waitForElementToLoad(LoginPanel.EMAIL_FIELD);
	}
	
	public void selectEditUser(User user) {
		Helper.selectElementContainedInList(USER_ROWS, user.getUsername(), EDIT_BUTTON);
	}
}