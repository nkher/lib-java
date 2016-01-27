package nkher.algorithms.hash;

public abstract class HashMethod {
	
	protected String hashFunctionName;
	
	
	public String getHashFunctionName() {
		return hashFunctionName;
	}
	
	public void setHashFunctionName(String name) {
		this.hashFunctionName = name;
	}
}
