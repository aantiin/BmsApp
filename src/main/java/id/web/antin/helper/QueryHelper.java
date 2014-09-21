package id.web.antin.helper;

public class QueryHelper {
	private String fieldName;
	private Operator operator;
	private Object value;

	public QueryHelper() {
		super();
	}

	public QueryHelper(String fieldName, Operator operator, Object value) {
		super();
		this.fieldName = fieldName;
		this.operator = operator;
		this.value = value;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public void setOperatorStr(String opr) {
		if ("EQ".equals(opr))
			operator = Operator.EQ;
		else if ("LIKE".equals(opr))
			operator = Operator.LIKE;
		else
			operator = Operator.NOTLIKE;
	}

	public String getOperatorStr() {
		return operator != null ? operator.toString() : null;
	}
	
	public boolean empty(){
		return fieldName == null || operator == null || value == null || 
	    		   "".equals( fieldName ) || "".equals( operator ) || "".equals( value );
	}
}
