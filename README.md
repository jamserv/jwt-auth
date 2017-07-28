## jwt-auth

OAuth is an open standard for access delegation, commonly used as a way for Internet users to grant websites or applications access to their information on other websites but without giving them the passwords.[1] This mechanism is used by companies such as Google, Facebook, Microsoft and Twitter to permit the users to share information about their accounts with third party applications or websites.

Generally, OAuth provides to clients a "secure delegated access" to server resources on behalf of a resource owner. It specifies a process for resource owners to authorize third-party access to their server resources without sharing their credentials. Designed specifically to work with Hypertext Transfer Protocol (HTTP), OAuth essentially allows access tokens to be issued to third-party clients by an authorization server, with the approval of the resource owner. The third party then uses the access token to access the protected resources hosted by the resource server.[2]

OAuth is a service that is complementary to and distinct from OpenID. OAuth is also distinct from OATH, which is a reference architecture for authentication, not a standard for authorization. However, OAuth is directly related to OpenID Connect (OIDC) since OIDC is an authentication layer built on top of OAuth 2.0. OAuth is also distinct from XACML, which is an authorization policy standard. OAuth can be used in conjunction with XACML where OAuth is used for ownership consent and access delegation whereas XACML is used to define the authorization policies (e.g. managers can view documents in their region).

## Security

On April 23, 2009, a session fixation security flaw in the 1.0 protocol was announced. It affects the OAuth authorization flow (also known as "3-legged OAuth") in OAuth Core 1.0 Section 6.[11] Version 1.0a of the OAuth Core protocol was issued to address this issue.[12]

OAuth 2.0 does not support signature, encryption, channel binding, or client verification. It relies completely on TLS for some degree of confidentiality and server authentication.[13][14]

OAuth 2.0 has had numerous security flaws exposed in implementations.[15] The protocol itself has been described as inherently insecure by security experts and a primary contributor to the specification stated that implementation mistakes are almost inevitable.[16][17]

In January 2013, the Internet Engineering Task Force published a number of threat models for OAuth 2.0.[18] Among them was one called "Open Redirector"; in the spring of 2014, this was described under the name "Covert Redirect" by Wang Jing.[19][20][21][22]

Possibly the most devastating OAuth security failure is phishing vulnerability:[23] every web site using OAuth is visually (but not technically) asking end users for their username and password of their master identity, which prevents ordinary users from understanding that they should not type those in should they encounter an attacker's web site that visually emulates this process to steal credentials. Traditional two-factor authentication (using One-time passwords) does not prevent this attack, because the phishing site can steal that as well, using it immediately (Note that Universal 2nd Factor tokens aren't vulnerable to this specific type attack).

In April–May 2017, about one million users of Gmail (less than 0.1% of users as of May 2017) were targeted by an OAuth-based phishing attack, receiving an email purporting to be from a colleague, employer or friend wanting to share a document on Google Docs.[24] Those who clicked on the link within the email were directed to sign in and allow a potentially malicious third-party program called "Google Apps" access their "email account, contacts and online documents".[24] Within "approximately one hour",[24] the phishing attack was stopped by Google, who advised those who had given "Google Apps" access to their email to revoke such access and change their passwords.
