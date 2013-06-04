<?xml version="1.0" encoding="UTF-8"?>


<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:ns0='http://www.bsu.by' version="1.0">
	<xsl:output method="html" />

	<!-- TODO customize transformation rules syntax recommendation http://www.w3.org/TR/xslt -->
	<xsl:param name="nameCategory" select='audio' />
	<xsl:param name="nameSubCategory" select='stereosystem' />
	<xsl:param name="lastName" select='bbb' />
	<xsl:param name="firstName" select='bbb' />
	<xsl:template match="/">
		<html>
			<head>
				<title>productsStylesheet.xsl</title>
			</head>
			<body>
				<table width="100%">
					<td width="30%" valign="top">

						<br />
						<br />

					</td>
					<td width="40%">
						<br />
						<br />
						Your orders:
						<table border="1">
							<thead allign="center">

								<td>
									MODEL
								</td>


							</thead>


							<xsl:apply-templates
								select="/ns0:orders/ns0:order/ns0:user[ns0:last-name=$lastName][ns0:first-name=$firstName]" />

						</table>
						<br />

						<br />
					</td>
					<td valign="bottom" align="left">
						<a href="post?command=viewCategory">View Categories</a>
					</td>

				</table>
			</body>
		</html>
	</xsl:template>


	<xsl:template match="/ns0:orders/ns0:order/ns0:user[ns0:last-name=$lastName]">
		<tr>
			<td>
				<xsl:value-of select="../ns0:model-of-product"></xsl:value-of>
			</td>
		</tr>

	</xsl:template>
</xsl:stylesheet>
