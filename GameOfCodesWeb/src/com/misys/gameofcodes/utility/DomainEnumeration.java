package com.misys.gameofcodes.utility;

public enum DomainEnumeration {
	ESSENCE_CORE (ConstantKeys.ESSENCE_CORE),
	EQUATION_LENDING(ConstantKeys.EQUATION_LENDING),
	EQUATION_CASHIERDEALS(ConstantKeys.EQUATION_CASHIERDEALS),
	EQUATION_ACCOUNTS(ConstantKeys.EQUATION_ACCOUNTS),
	MIDAS_FUNDSTRANSFER(ConstantKeys.MIDAS_FUNDSTRANSFER),
	MIDAS_ADVOCATES(ConstantKeys.MIDAS_ADVOCATES),
	MIDAS_LENDING(ConstantKeys.MIDAS_LENDING);
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
