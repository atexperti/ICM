package org.icm.jaxb.util;

public class LayoutPages {

	private String ls1;
	private String ls2;
	private String ls3;
	private String rs1;
	private String rs2;
	private String rs3;
	private String ns1;
	private String ns2;
	private String ns3;
	private String ns4;
	private String ns5;
	private String ns6;
	private String bs1;
	private String bs2;
	
	private Layout layout;
	public final String INCLUDEFILESPATH="/WEB-INF/jsp/includes/";
	
	public LayoutPages(Layout layout) {
		
		setLayout(layout);
		setLs1(layout.getLeftside().getLs1());
		setLs2(layout.getLeftside().getLs2());
		setLs3(layout.getLeftside().getLs3());
		setRs1(layout.getRightside().getRs1());
		setRs2(layout.getRightside().getRs2());
		setRs3(layout.getRightside().getRs3());
		setNs1(layout.getHeader().getHns1());
		setNs2(layout.getHeader().getHns2());
		setNs3(layout.getHeader().getHns3());
		setNs4(layout.getHeader().getHns4());
		setNs5(layout.getHeader().getHns5());
		setNs6(layout.getHeader().getHns6());
		setBs1(layout.getBody().getSection1());
		setBs2(layout.getBody().getSection2());
	}


	/**
	 * @return the ls1
	 */
	public String getLs1() {
		return ls1;
	}


	/**
	 * @param ls1 the ls1 to set
	 */
	public void setLs1(String ls1) {
		this.ls1 = ls1;
	}


	/**
	 * @return the ls2
	 */
	public String getLs2() {
		return ls2;
	}


	/**
	 * @param ls2 the ls2 to set
	 */
	public void setLs2(String ls2) {
		this.ls2 = ls2;
	}


	/**
	 * @return the ls3
	 */
	public String getLs3() {
		return ls3;
	}


	/**
	 * @param ls3 the ls3 to set
	 */
	public void setLs3(String ls3) {
		this.ls3 = ls3;
	}


	/**
	 * @return the rs1
	 */
	public String getRs1() {
		return  rs1;
	}


	/**
	 * @param rs1 the rs1 to set
	 */
	public void setRs1(String rs1) {
		this.rs1 = rs1;
	}


	/**
	 * @return the rs2
	 */
	public String getRs2() {
		return rs2;
	}


	/**
	 * @param rs2 the rs2 to set
	 */
	public void setRs2(String rs2) {
		this.rs2 = rs2;
	}


	/**
	 * @return the rs3
	 */
	public String getRs3() {
		return rs3;
	}


	/**
	 * @param rs3 the rs3 to set
	 */
	public void setRs3(String rs3) {
		this.rs3 = rs3;
	}


	/**
	 * @return the ns1
	 */
	public String getNs1() {
		return ns1;
	}


	/**
	 * @param ns1 the ns1 to set
	 */
	public void setNs1(String ns1) {
		this.ns1 = ns1;
	}


	/**
	 * @return the ns2
	 */
	public String getNs2() {
		return ns2;
	}


	/**
	 * @param ns2 the ns2 to set
	 */
	public void setNs2(String ns2) {
		this.ns2 = ns2;
	}


	/**
	 * @return the ns3
	 */
	public String getNs3() {
		return  ns3;
	}


	/**
	 * @param ns3 the ns3 to set
	 */
	public void setNs3(String ns3) {
		this.ns3 =ns3;
	}


	/**
	 * @return the ns4
	 */
	public String getNs4() {
		return ns4;
	}


	/**
	 * @param ns4 the ns4 to set
	 */
	public void setNs4(String ns4) {
		this.ns4 = ns4;
	}


	/**
	 * @return the ns5
	 */
	public String getNs5() {
		return ns5;
	}


	/**
	 * @param ns5 the ns5 to set
	 */
	public void setNs5(String ns5) {
		this.ns5 = ns5;
	}


	/**
	 * @return the ns6
	 */
	public String getNs6() {
		return ns6;
	}


	/**
	 * @param ns6 the ns6 to set
	 */
	public void setNs6(String ns6) {
		this.ns6 = ns6;
	}


	/**
	 * @return the bs1
	 */
	public String getBs1() {
		return bs1;
	}


	/**
	 * @param bs1 the bs1 to set
	 */
	public void setBs1(String bs1) {
		this.bs1 = INCLUDEFILESPATH+bs1+".jsp";
	}


	/**
	 * @return the bs2
	 */
	public String getBs2() {
		return bs2;
	}


	/**
	 * @param bs2 the bs2 to set
	 */
	public void setBs2(String bs2) {
		this.bs2 = INCLUDEFILESPATH+bs2+".jsp";
	}


	/**
	 * @param layout the layout to set
	 */
	public void setLayout(Layout layout) {
		this.layout = layout;
	}


	/**
	 * @return the layout
	 */
	public Layout getLayout() {
		return layout;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LayoutPages [ls1=" + ls1 + ", ls2=" + ls2 + ", ls3=" + ls3
				+ ", rs1=" + rs1 + ", rs2=" + rs2 + ", rs3=" + rs3 + ", ns1="
				+ ns1 + ", ns2=" + ns2 + ", ns3=" + ns3 + ", ns4=" + ns4
				+ ", ns5=" + ns5 + ", ns6=" + ns6 + ", bs1=" + bs1 + ", bs2="
				+ bs2 + ", layout=" + layout + ", INCLUDEFILESPATH="
				+ INCLUDEFILESPATH + "]";
	}

	
}
