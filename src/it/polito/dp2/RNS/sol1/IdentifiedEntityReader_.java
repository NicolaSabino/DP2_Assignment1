package it.polito.dp2.RNS.sol1;

public class IdentifiedEntityReader_ implements it.polito.dp2.RNS.IdentifiedEntityReader {
	
	protected String id;
	
	public IdentifiedEntityReader_(String id) {
		this.id = id;
	}
	
	@Override
	public String getId() {
		return this.id;
	}

}