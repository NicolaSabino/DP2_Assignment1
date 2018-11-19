package it.polito.dp2.RNS.sol1;

public class IdentifiedEntityReader implements it.polito.dp2.RNS.IdentifiedEntityReader {
	
	protected String id;
	
	public IdentifiedEntityReader(String id) {
		// TODO Auto-generated constructor stub
		this.id = id;
	}
	
	@Override
	public String getId() {
		return this.id;
	}

}
