<?xml version="1.0" encoding="UTF-8"?>



<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:ns0='http://www.bsu.by' version="1.0">
    <xsl:output method="html"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:param name="nameCategory" select="'audio'"/>
    <xsl:template match="/">
        <html>
            <head>
                <title>productsStylesheet.xsl</title>
            </head>
            <body>
                <table width="100%" >
                    <td width="30%" valign="top">
                        <xsl:value-of select="$nameCategory"/>
                      
                        <br/>
                  
                    </td>
                    <td width="30%">
                        <br />
                        <br />
                        <xsl:apply-templates select="/ns0:products/ns0:category[@name=$nameCategory]/ns0:subcategory"/>
                        <br />
                        <br />
                        </td>
                        <td valign="bottom" align="left">
                        <p>
                            <a href="post?command=return">Back</a>
                        </p>
                    </td>
                </table>
            </body>
        </html>
    </xsl:template>




    <xsl:template match="/ns0:products/ns0:category[@name=$nameCategory]/ns0:subcategory">
     
        <xsl:variable name="subCategory" select="./@name"/>

        <a href="post?command=viewProducts&amp;category={$nameCategory}&amp;subCategory={$subCategory}">
            <xsl:value-of select="$subCategory"/>
        </a>
        (
        <xsl:value-of select="count(./ns0:product)"/>)
        <br />
        <br />
    </xsl:template>

</xsl:stylesheet>
