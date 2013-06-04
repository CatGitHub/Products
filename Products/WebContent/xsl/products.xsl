<?xml version="1.0" encoding="UTF-8"?>


<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:ns0='http://www.bsu.by' version="1.0">
	<xsl:output method="html" />

	<!-- TODO customize transformation rules syntax recommendation http://www.w3.org/TR/xslt -->
	<xsl:param name="nameCategory" select='audio' />
	<xsl:param name="nameSubCategory" select='stereosystem' />
	<xsl:template match="/">
		<html>
			<head>
				<title>productsStylesheet.xsl</title>
			</head>
			<body>
		
				<table width="100%">
					<td width="30%" valign="top">
						<xsl:value-of select="$nameCategory" />&gt;&gt;
						<xsl:value-of select="$nameSubCategory" />
						<br />
						<br />

					</td>
					<td width="40%">
						<br />
						<br />

						<table border="1">
							<thead allign="center">
								<td>
									PROVIDER
								</td>
								<td>
									MODEL
								</td>

								<td>
									COLOR
								</td>
								<td>
									PRICE
								</td>
								<td>
									ORDER
								</td>
							</thead>


							<xsl:apply-templates
								select="/ns0:products/ns0:category[@name=$nameCategory]/ns0:subcategory[@name=$nameSubCategory]/ns0:product" />
						</table>
						<br />
						
						<br />
					</td>
					<td valign="bottom" align="left">
						<a
							href="post?command=return&amp;category={$nameCategory}&amp;subCategory={$nameSubCategory}">Back</a>
					</td>

				</table>
			</body>
		</html>
	</xsl:template>
<!--  
	<xsl:template name="login">
		<form method="post" action="/Products/post">
			<input type="hidden" name="command" value="login" />



			<table border="0">
				<tr>
					<td>
						name
					</td>
					<td>
						<input type="text" name="name">

						</input>
					</td>
				</tr>
				<tr>
					<td>
						password
					</td>
					<td>
						<input type="password" name="password">

						</input>
					</td>
				</tr>
				<tr>
					<td>
					</td>
					<td>
						<input type="submit" class="button" value="Login" />
					</td>
				</tr>
			</table>
		</form>

	</xsl:template>

-->

	<xsl:template
		match="/ns0:products/ns0:category[@name=$nameCategory]/ns0:subcategory[@name=$nameSubCategory]/ns0:product">
		<xsl:variable name="price" select="ns0:price" />
		<xsl:variable name="model" select="./ns0:model"/>
		<tr>
			<td>
				<xsl:value-of select="ns0:producer" />
			</td>
			<td>
				<xsl:value-of select="ns0:model"/>
				
			</td>

			<td>
				<xsl:value-of select="ns0:color" />
			</td>
			<td>


				<xsl:value-of select="$price" />

			</td>
			<td>


				<a href="post?command=makeOrder&amp;category={$nameCategory}&amp;subCategory={$nameSubCategory}&amp;model={$model}">Make Order</a>

			</td>
		</tr>
	</xsl:template>
</xsl:stylesheet>
