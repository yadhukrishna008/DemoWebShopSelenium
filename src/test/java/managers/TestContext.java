package managers;

import utils.GenericUtils;
import utils.PageUtils;

public class TestContext {
	public PageObjectManager pageObjectManager;
	public PageUtils pageUtils;
	public GenericUtils genericUtils;
	
	public TestContext(){
		pageObjectManager = new PageObjectManager();
		pageUtils= new PageUtils();
		genericUtils= new GenericUtils();
	}
}
