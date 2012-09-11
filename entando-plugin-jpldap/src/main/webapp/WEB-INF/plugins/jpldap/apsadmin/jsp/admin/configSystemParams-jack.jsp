<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="/apsadmin-form" prefix="wpsf" %>
<%@ taglib uri="/apsadmin-core" prefix="wpsa" %>

<fieldset>
	<legend><s:text name="jpldap.name" /></legend>
	<p>
        <s:set name="jpldap_paramName" value="'jpldap_active'" />
        <input type="checkbox" class="radiocheck" id="<s:property value="#jpldap_paramName"/>" name="<s:property value="#jpldap_paramName"/>" value="true" <s:if test="systemParams.get(#jpldap_paramName)">checked="checked"</s:if> />
        <wpsf:hidden name="%{#jpldap_paramName + externalParamMarker}" value="true"/>
        <label for="<s:property value="#jpldap_paramName" />"><s:text name="label.active" /></label>
	</p>
	<p>
        <s:set name="jpldap_paramName" value="'jpldap_providerUrl'" />
        <label for="<s:property value="#jpldap_paramName"/>" class="basic-mint-label"><s:text name="jpldap.hookpoint.configSystemParams.providerUrl" />:</label>
		<wpsf:textfield useTabindexAutoIncrement="true" name="%{#jpldap_paramName}" id="%{#jpldap_paramName}" value="%{systemParams.get(#jpldap_paramName)}" cssClass="text" />
        <wpsf:hidden name="%{#jpldap_paramName + externalParamMarker}" value="true"/>
	</p>
	<p>
        <s:set name="jpldap_paramName" value="'jpldap_securityPrincipal'" />
        <label for="<s:property value="#jpldap_paramName"/>" class="basic-mint-label"><s:text name="jpldap.hookpoint.configSystemParams.securityPrincipal" />:</label>
		<wpsf:textfield useTabindexAutoIncrement="true" name="%{#jpldap_paramName}" id="%{#jpldap_paramName}" value="%{systemParams.get(#jpldap_paramName)}" cssClass="text" />
        <wpsf:hidden name="%{#jpldap_paramName + externalParamMarker}" value="true"/>
	</p>
	<p>
        <s:set name="jpldap_paramName" value="'jpldap_securityCredentials'" />
        <label for="<s:property value="#jpldap_paramName"/>" class="basic-mint-label"><s:text name="jpldap.hookpoint.configSystemParams.securityCredentials" />:</label>
		<wpsf:textfield useTabindexAutoIncrement="true" name="%{#jpldap_paramName}" id="%{#jpldap_paramName}" value="%{systemParams.get(#jpldap_paramName)}" cssClass="text" />
        <wpsf:hidden name="%{#jpldap_paramName + externalParamMarker}" value="true"/>
	</p>
	<p>
        <s:set name="jpldap_paramName" value="'jpldap_userObjectClass'" />
        <label for="<s:property value="#jpldap_paramName"/>" class="basic-mint-label"><s:text name="jpldap.hookpoint.configSystemParams.userObjectClass" />:</label>
		<wpsf:textfield useTabindexAutoIncrement="true" name="%{#jpldap_paramName}" id="%{#jpldap_paramName}" value="%{systemParams.get(#jpldap_paramName)}" cssClass="text" />
        <wpsf:hidden name="%{#jpldap_paramName + externalParamMarker}" value="true"/>
	</p>
	<p>
        <s:set name="jpldap_paramName" value="'jpldap_userIdAttributeName'" />
        <label for="<s:property value="#jpldap_paramName"/>" class="basic-mint-label"><s:text name="jpldap.hookpoint.configSystemParams.userIdAttributeName" />:</label>
		<wpsf:textfield useTabindexAutoIncrement="true" name="%{#jpldap_paramName}" id="%{#jpldap_paramName}" value="%{systemParams.get(#jpldap_paramName)}" cssClass="text" />
        <wpsf:hidden name="%{#jpldap_paramName + externalParamMarker}" value="true"/>
	</p>
	<p>
        <s:set name="jpldap_paramName" value="'jpldap_filterGroup'" />
        <label for="<s:property value="#jpldap_paramName"/>" class="basic-mint-label"><s:text name="jpldap.hookpoint.configSystemParams.filterGroup" />:</label>
		<wpsf:textfield useTabindexAutoIncrement="true" name="%{#jpldap_paramName}" id="%{#jpldap_paramName}" value="%{systemParams.get(#jpldap_paramName)}" cssClass="text" />
        <wpsf:hidden name="%{#jpldap_paramName + externalParamMarker}" value="true"/>
	</p>
	<p>
        <s:set name="jpldap_paramName" value="'jpldap_filterGroupAttributeName'" />
        <label for="<s:property value="#jpldap_paramName"/>" class="basic-mint-label"><s:text name="jpldap.hookpoint.configSystemParams.filterGroupAttributeName" />:</label>
		<wpsf:textfield useTabindexAutoIncrement="true" name="%{#jpldap_paramName}" id="%{#jpldap_paramName}" value="%{systemParams.get(#jpldap_paramName)}" cssClass="text" />
        <wpsf:hidden name="%{#jpldap_paramName + externalParamMarker}" value="true"/>
	</p>
	<p>
        <s:set name="jpldap_paramName" value="'jpldap_searchResultMaxSize'" />
        <label for="<s:property value="#jpldap_paramName"/>" class="basic-mint-label"><s:text name="jpldap.hookpoint.configSystemParams.searchResultMaxSize" />:</label>
		<wpsf:textfield useTabindexAutoIncrement="true" name="%{#jpldap_paramName}" id="%{#jpldap_paramName}" value="%{systemParams.get(#jpldap_paramName)}" cssClass="text" />
        <wpsf:hidden name="%{#jpldap_paramName + externalParamMarker}" value="true"/>
	</p>
	
	<p>
        <s:set name="jpldap_paramName" value="'jpldap_userEditingActive'" />
        <input type="checkbox" class="radiocheck" id="<s:property value="#jpldap_paramName"/>" name="<s:property value="#jpldap_paramName"/>" value="true" <s:if test="systemParams.get(#jpldap_paramName)">checked="checked"</s:if> />
        <wpsf:hidden name="%{#jpldap_paramName + externalParamMarker}" value="true"/>
        <label for="<s:property value="#jpldap_paramName" />"><s:text name="jpldap.hookpoint.configSystemParams.userEditingActive" /></label>
	</p>
	<p>
        <s:set name="jpldap_paramName" value="'jpldap_userBaseDN'" />
        <label for="<s:property value="#jpldap_paramName"/>" class="basic-mint-label"><s:text name="jpldap.hookpoint.configSystemParams.userBaseDN" />:</label>
		<wpsf:textfield useTabindexAutoIncrement="true" name="%{#jpldap_paramName}" id="%{#jpldap_paramName}" value="%{systemParams.get(#jpldap_paramName)}" cssClass="text" />
        <wpsf:hidden name="%{#jpldap_paramName + externalParamMarker}" value="true"/>
	</p>
	<p>
        <s:set name="jpldap_paramName" value="'jpldap_userObjectClassesCSV'" />
        <label for="<s:property value="#jpldap_paramName"/>" class="basic-mint-label"><s:text name="jpldap.hookpoint.configSystemParams.userObjectClassesCSV" />:</label>
		<wpsf:textfield useTabindexAutoIncrement="true" name="%{#jpldap_paramName}" id="%{#jpldap_paramName}" value="%{systemParams.get(#jpldap_paramName)}" cssClass="text" />
        <wpsf:hidden name="%{#jpldap_paramName + externalParamMarker}" value="true"/>
	</p>
	<p>
        <s:set name="jpldap_paramName" value="'jpldap_ouObjectClassesCSV'" />
        <label for="<s:property value="#jpldap_paramName"/>" class="basic-mint-label"><s:text name="jpldap.hookpoint.configSystemParams.ouObjectClassesCSV" />:</label>
		<wpsf:textfield useTabindexAutoIncrement="true" name="%{#jpldap_paramName}" id="%{#jpldap_paramName}" value="%{systemParams.get(#jpldap_paramName)}" cssClass="text" />
        <wpsf:hidden name="%{#jpldap_paramName + externalParamMarker}" value="true"/>
	</p>
	<p>
        <s:set name="jpldap_paramName" value="'jpldap_userRealAttributeName'" />
        <label for="<s:property value="#jpldap_paramName"/>" class="basic-mint-label"><s:text name="jpldap.hookpoint.configSystemParams.userRealAttributeName" />:</label>
		<wpsf:textfield useTabindexAutoIncrement="true" name="%{#jpldap_paramName}" id="%{#jpldap_paramName}" value="%{systemParams.get(#jpldap_paramName)}" cssClass="text" />
        <wpsf:hidden name="%{#jpldap_paramName + externalParamMarker}" value="true"/>
	</p>
	<p>
        <s:set name="jpldap_paramName" value="'jpldap_userPasswordAttributeName'" />
        <label for="<s:property value="#jpldap_paramName"/>" class="basic-mint-label"><s:text name="jpldap.hookpoint.configSystemParams.userPasswordAttributeName" />:</label>
		<wpsf:textfield useTabindexAutoIncrement="true" name="%{#jpldap_paramName}" id="%{#jpldap_paramName}" value="%{systemParams.get(#jpldap_paramName)}" cssClass="text" />
        <wpsf:hidden name="%{#jpldap_paramName + externalParamMarker}" value="true"/>
	</p>
	
</fieldset>