package Model;

import java.io.Serializable;

public class Stat implements Serializable{

	private static final long serialVersionUID = 1L;
	static public enum TypeEnum { TRAVEL , BAD_PASS , TREE_SEC 
		, BACK_COURT , FOUL , TECHNICAL_FOUL , OFF_REBOUND 
		, DEF_REBOUND , ASSIST , NONE};
		
		TypeEnum type;
		QuarterEnum quarter;
		
		
		public Stat(){}
		
		public Stat(TypeEnum type, QuarterEnum quarter) {
			this.type = type;
			this.quarter = quarter;
		}
		
		public TypeEnum getType() {
			return type;
		}
		public void setType(TypeEnum type) {
			this.type = type;
		}
		public QuarterEnum getQuarter() {
			return quarter;
		}
		public void setQuarter(QuarterEnum quarter) {
			this.quarter = quarter;
		}
}
