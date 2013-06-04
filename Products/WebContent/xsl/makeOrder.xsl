<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:ns0='http://www.bsu.by' xmlns:products="xalan://by.bsu.products.form.ProductsForm"

	version="1.0">

	<xsl:output method="html" />

	<xsl:param name="nameCategory" select="'audio'" />
	<xsl:param name="nameSubCategory" select="'stereosystem'" />
	<xsl:param name="nameModel" select="'000000'" />


	<xsl:template match="/">

		<xsl:call-template name="makeOrder" />
	</xsl:template>

	<xsl:template name="makeOrder">

		<html>
			<head>
				<title>makeOrder.xsl</title>
			</head>
			<body>


				<table width="100%">
					<td width="30%" valign="top">
						<xsl:value-of select="$nameCategory" />&gt;&gt;
						<xsl:value-of select="$nameSubCategory" />
						<br />
						<br />

					</td>
					<td>
						<br />
						<br />
						<form method="post" action="/Products/post">
							<input type="hidden" name="command" value="saveOrder" />
							<input type="hidden" name="category" value="{$nameCategory}" />
							<input type="hidden" name="subCategory" value="{$nameSubCategory}" />
							<input type="hidden" name="model" value="{$nameModel}" />

							<table border="0">
								<tr>
									<td>Model of product:
									</td>
									<td>
									<xsl:value-of select="$nameModel" />
									</td>
								</tr>
								<tr>
									<td>
										First name:
									</td>
									<td>
										<input type="text" name="firstName">

										</input>
									</td>


								</tr>
								<tr>
									<td>Last name:

									</td>

									<td>
										<input type="text" name="lastName">

										</input>
									</td>

								</tr>



								<tr>
									<td></td>
									<td align="right">

										<input type="submit" class="button" value="Make Order" />

									</td>

								</tr>
							</table>
						</form>
					</td>
				</table>
			</body>
		</html>
	</xsl:template>

</xsl:stylesheet>