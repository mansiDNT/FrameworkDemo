package com.utility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.testng.IInvokedMethod;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestClass;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.collections.Lists;
import org.testng.log4testng.Logger;
import org.testng.xml.XmlSuite;

import com.init.SeleniumInit;

public class CustomReporterByMansi extends CustomReporterListener {
	/*
	 * 
	 * private PrintWriter m_out; private static final Logger L = Logger
	 * .getLogger(CustomReporterListener.class);
	 * 
	 *//** Creates summary of the run */
	/*
	 * @Override public void generateReport(List<XmlSuite> xml, List<ISuite> suites,
	 * String outdir) { //1 try { m_out = createWriter(outdir); //2 } catch
	 * (IOException e) { L.error("output file", e); return; }
	 * 
	 * startHtml(m_out); //3 generateSuiteSummaryReport(suites); TotalTime(suites);
	 * //4 generateMethodSummaryReport(suites); //5
	 * 
	 * // generateMethodDetailReport(suites);
	 * 
	 * //endHtml(m_out); //previous m_out.flush(); m_out.close(); }
	 * 
	 * protected void generateMethodSummaryReport(List<ISuite> suites) { //5.1
	 * m_methodIndex = 0; startResultSummaryTable("methodOverview"); //5.2 int
	 * testIndex = 1; for (ISuite suite : suites) { if (suites.size() > 1) {
	 * //titleRow(suite.getName(), 5); } Map<String, ISuiteResult> r =
	 * suite.getResults(); for (ISuiteResult r2 : r.values()) { ITestContext
	 * testContext = r2.getTestContext(); String testName = testContext.getName();
	 * m_testIndex = testIndex; //resultSummary_passed(suite,
	 * testContext.getPassedTests()); //5.3 System.out.println("Passed---");
	 * resultSummary_passed(suite, testContext.getPassedTests(), testName, "passed",
	 * ""); resultSummarypassed(suite, testContext.getPassedTests(), //5.4 testName,
	 * "passed", " (configuration methods)"); System.out.println("Failed---");
	 * resultSummary(suite, testContext.getFailedConfigurations(), //5.4 testName,
	 * "failed", " (configuration methods)"); resultSummary(suite,
	 * testContext.getFailedTests(), testName, "failed", "");
	 * System.out.println("Skipped---");
	 * 
	 * resultSummary_skipped(suite, testContext.getSkippedTests(), testName,
	 * "skipped", ""); resultSummarypassed(suite, testContext.getSkippedTests(),
	 * //5.4 testName, "passed", " (configuration methods)");
	 * 
	 * 
	 * resultSummary(suite, testContext.getSkippedConfigurations(), testName,
	 * "skipped", " (configuration methods)"); resultSummary(suite,
	 * testContext.getSkippedTests(), testName, "skipped", ""); resultSummary(suite,
	 * testContext.getPassedTests(), testName, "passed", "");
	 * 
	 * 
	 * testIndex++;
	 * 
	 * }
	 * 
	 * } endHtml(m_out); testCaseNo(); m_out.println("</table>"); }
	 * 
	 * 
	 * public String TotalTime(List<ISuite> suites) { //4.1 long time_start =
	 * Long.MAX_VALUE; long time_end = Long.MIN_VALUE; ITestContext overview = null;
	 * 
	 * for (ISuite suite : suites) { Map<String, ISuiteResult> itests =
	 * suite.getResults(); for (ISuiteResult r : itests.values()) {
	 * 
	 * overview = r.getTestContext();
	 * 
	 * time_start = Math.min(overview.getStartDate().getTime(), time_start);
	 * time_end = Math.max(overview.getEndDate().getTime(), time_end);
	 * 
	 * } } // m_out.println("</tr><td  class=\"numi\"><center>"+((time_end - //
	 * time_start) / 1000.) / 60.+"</center></td> </tr>"); NumberFormat formatter =
	 * new DecimalFormat("#,##0.0"); Time = String.valueOf(formatter
	 * .format(((time_end - time_start) / 1000.) / 60.));
	 * 
	 * return Time; }
	 * 
	 * protected PrintWriter createWriter(String outdir) throws IOException { //2.1
	 * // java.util.Date now = new Date(); new File(outdir).mkdirs(); return new
	 * PrintWriter(new BufferedWriter(new FileWriter(new File( outdir,
	 * "CustomReporterByMansi" + ".html")))); }
	 * 
	 * 
	 *//** Starts HTML stream */
	/*
	 * protected void startHtml(PrintWriter out) { //3.1 out.
	 * println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.1//EN\" \"http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd\">"
	 * ); out.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
	 * out.println("<head>");
	 * out.println("<title> Automation build Summary - TestNG Report</title>");
	 * out.println("<style type=\"text/css\">"); out.
	 * println("table {margin-bottom:1px;border-collapse:collapse;empty-cells:show}"
	 * ); out.println("td,th {solid #009;padding:.25em .5em;}");
	 * out.println("td,th {solid #009;padding:.25em .5em;}");
	 * out.println(".result th {vertical-align:bottom}");
	 * out.println(".param th {padding-left:1em;padding-right:1em}");
	 * out.println(".param td {padding-left:.5em;padding-right:2em}");
	 * out.println(".stripe td,.stripe th {background-color: #E6EBF9}");
	 * out.println(".numi,.numi_attn {text-align:right}");
	 * out.println(".total td {font-weight:bold}");
	 * out.println(".passedodd td {background-color: #0A0}");
	 * out.println(".passedeven td {background-color: #3F3}");
	 * out.println(".skippedodd td {background-color: #CCC}");
	 * out.println(".skippedodd td {background-color: #DDD}");
	 * out.println(".failedodd td,.numi_attn {background-color: #F9C1C1}");
	 * out.println(".failedeven td,.stripe .numi_attn {background-color: #F9C1C1}");
	 * out.println(".stacktrace {white-space:pre;}"); out.
	 * println(".totop {font-size:85%;text-align:center;border-bottom:2px solid #000}"
	 * ); out.println("html * {");
	 * 
	 * out.println(" font-family: \"Open Sans\",sans-serif; font-size:11px;}");
	 * out.println("h1  { font-size:25px;  }");
	 * out.println("th {font-size:14px; }");
	 * 
	 *//*** Collapse expands ****/
	/*
	 * 
	 * out.println(".list { display:none;"); out.println("height:auto;");
	 * out.println(" margin:0;"); out.println("float: left; }");
	 * 
	 * out.println(".show {"); out.println("display: none; }");
	 * out.println(".hide:target + .show {"); out.println("display: inline; }");
	 * out.println(".hide:target {"); out.println("display: none; }");
	 * out.println(".hide:target ~ .list {"); out.println("display:inline; }");
	 * 
	 * 
	 * style the (+) and (-) out.println(".hide, .show {");
	 * out.println("width: 16px;"); out.println("height: 16px;");
	 * out.println("border-radius: 30px;"); out.println("font-size: 15px;");
	 * out.println("color: #000;"); out.println("text-shadow: 0 1px 0 #666;");
	 * out.println("text-align: center;"); out.println("text-decoration: none;");
	 * out.println("box-shadow: 1px 1px 2px #000;");
	 * out.println("background: #91DDFE;"); out.println("opacity: .95;");
	 * out.println("margin-right: 0;"); out.println("float: left;");
	 * out.println("margin-bottom: 25px; }");
	 * 
	 * out.println(".hide:hover, .show:hover {"); out.println("color: #eee;");
	 * out.println("text-shadow: 0 0 1px #666;");
	 * out.println("text-decoration: none;");
	 * out.println("box-shadow: 0 0 4px #222 inset;"); out.println("opacity: 1;");
	 * out.println("margin-bottom: 25px; }");
	 * 
	 * out.println(".list tr{"); out.println("height:auto;");
	 * out.println("margin:0; }");
	 * 
	 *//**********************/
	/*
	 * out.println("</style>"); out.
	 * println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>"
	 * ); out.println("<script>"); out.println("$(document).ready(function(){"); for
	 * (int i=1;i<180;i++) { out.println(" $(\"#test"+i+"\").click(function(){");
	 * out.println("$(\"#t"+i+"\").toggle(100);"); out.println("});"); }
	 * 
	 * for (int i = 0; i < CustomReporterTestFailureDetails.failedtoggles.size();
	 * i++) {
	 * out.println(" $(\"#test"+CustomReporterTestFailureDetails.failedtoggles.get(i
	 * )+"\").click(function(){");
	 * out.println("$(\"#t"+CustomReporterTestFailureDetails.failedtoggles.get(i)+
	 * "\").toggle(100);"); out.println("});"); }
	 * 
	 * for (int i = 0; i < CustomReporterTestpassDetails.passedtoggles.size(); i++)
	 * {
	 * out.println(" $(\"#test"+CustomReporterTestpassDetails.passedtoggles.get(i)+
	 * "\").click(function(){");
	 * out.println("$(\"#t"+CustomReporterTestpassDetails.passedtoggles.get(i)+
	 * "\").toggle(100);"); out.println("});"); }
	 * 
	 * for (int i = 0; i < CustomReporterTestskipDetails.skiptoggles.size(); i++) {
	 * out.println(" $(\"#test"+CustomReporterTestskipDetails.skiptoggles.get(i)+
	 * "\").click(function(){");
	 * out.println("$(\"#t"+CustomReporterTestskipDetails.skiptoggles.get(i)+
	 * "\").toggle(100);"); out.println("});"); } out.println("});");
	 * out.println("</script>"); out.println("</head>"); out.println("<body>"); }
	 * 
	 * @SuppressWarnings("unused") public void
	 * generateSuiteSummaryReport(List<ISuite> suites) { tableStart("testOverview",
	 * null); m_out.print("<tr>"); tableColumnStart("Test");
	 * tableColumnStart("Methods<br/>Passed"); tableColumnStart("# skipped");
	 * tableColumnStart("# failed"); tableColumnStart("Browser");
	 * tableColumnStart("Start<br/>Time"); tableColumnStart("End<br/>Time");
	 * tableColumnStart("Total<br/>Time(hh:mm:ss)");
	 * tableColumnStart("Included<br/>Groups");
	 * tableColumnStart("Excluded<br/>Groups");
	 * 
	 * m_out.println("</tr>"); NumberFormat formatter = new
	 * DecimalFormat("#,##0.0");
	 * 
	 * int qty_pass_m = 0; int qty_pass_s = 0; int qty_skip = 0; long time_start =
	 * Long.MAX_VALUE; int qty_fail = 0; long time_end = Long.MIN_VALUE; m_testIndex
	 * = 1; for (ISuite suite : suites) { if (suites.size() >= 1) {
	 * //titleRow(suite.getName(), 10); } Map<String, ISuiteResult> tests =
	 * suite.getResults(); for (ISuiteResult r : tests.values()) { qty_tests += 1;
	 * ITestContext overview = r.getTestContext();
	 * 
	 * //startSummaryRow(overview.getName()); int q =
	 * getMethodSet(overview.getPassedTests(), suite).size(); qty_pass_m += q;
	 * 
	 * System.err.println("aa----->"+qty_tests); } } }
	 * 
	 */}
