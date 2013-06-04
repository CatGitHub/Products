<?xml version="1.0" encoding="UTF-8"?>


<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:ns0='http://www.bsu.by' version="1.0">
	<xsl:output method="html" />

	<!-- TODO customize transformation rules syntax recommendation http://www.w3.org/TR/xslt -->
	<xsl:template match="/">
	
		<html>
	
			<head>
				<title>productsStylesheet.xsl</title>
			</head>
			<body>
		
				<table width="100%">
					<td width="30%"></td>
					<td width="t0%">
						<br />
						<xsl:apply-templates />
					</td>



				</table>
			</body>
		</html>
	</xsl:template>

	

	<xsl:template match="ns0:category">

		<xsl:variable name="category" select="./@name" />

		<a href="post?command=viewSubCategory&amp;category={$category}">
			<xsl:value-of select="$category" />
		</a>
		(
		<xsl:value-of select="count(./ns0:subcategory/ns0:product)" />
		)
		<br />
		<br />

		<!-- <xsl:apply-templates select="ns0:subcategory"/> -->

	</xsl:template>


	<!--<xsl:template match="ns0:subcategory"> Subcategory: <xsl:value-of select="./@name"/> 
		( <xsl:value-of select="count(./ns0:product)"/>) <br /> <br /> </xsl:template> -->
</xsl:stylesheet>