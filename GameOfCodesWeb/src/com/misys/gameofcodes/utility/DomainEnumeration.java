package com.misys.gameofcodes.utility;

public enum DomainEnumeration {
	ESSENCE_CORE (ConstantKeys.ESSENCE_CORE),
	EQUATION_LENDING(ConstantKeys.EQUATION_LENDING),
	EQUATION_CASHIERDEALS(ConstantKeys.EQUATION_CASHIERDEALS);
	
	private final String text;

    /**
     * @param text
     */
    private DomainEnumeration(final String text) {
        this.text = text;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return text;
    }

}
