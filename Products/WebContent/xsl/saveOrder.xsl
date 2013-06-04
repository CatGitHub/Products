<?xml version="1.0" encoding="UTF-8"?>


<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:ns0='http://www.bsu.by' xmlns:orders="xalan://by.bsu.products.form.Order"

	version="1.0">


	<!-- TODO customize transformation rules syntax recommendation http://www.w3.org/TR/xslt -->
	<xsl:param name="nameCategory" select="'audio'" />
	<xsl:param name="nameSubCategory" select="'stereosystem'" />
	<xsl:param name="order" />






	<xsl:output method="html" />


	<xsl:template match="/">


		<xsl:copy>
			<xsl:apply-templates select="node()|@*" />
		</xsl:copy>




	</xsl:template>
	<xsl:template match="node()|@*">

		<xsl:copy>
			<xsl:apply-templates select="node()|@*" />
		</xsl:copy>


	</xsl:template>

	<xsl:template match="/ns0:orders">
		<xsl:copy>
			<xsl:apply-templates select="node()|@*" />
			<xsl:variable name="price" select="ns0:price" />

			<xsl:element name="ns0:order">


				<xsl:element name="ns0:model-of-product">
					<xsl:value-of select="orders:getModel($order)" />
				</xsl:element>

				<xsl:element name="ns0:user">
					<xsl:element name="ns0:first-name">
						<xsl:value-of select="orders:getFirstName($order)" />
					</xsl:element>
					<xsl:element name="ns0:last-name">
						<xsl:value-of select="orders:getLastName($order)" />
					</xsl:element>
				</xsl:element>


			</xsl:element>
		</xsl:copy>

	</xsl:template>

</xsl:stylesheet>
