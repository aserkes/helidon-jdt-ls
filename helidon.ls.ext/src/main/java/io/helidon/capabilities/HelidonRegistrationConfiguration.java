package io.helidon.capabilities;

import org.eclipse.lsp4j.DocumentFilter;
import org.eclipse.lsp4j.Registration;
import org.eclipse.lsp4j.TextDocumentRegistrationOptions;
import org.eclipse.lsp4mp.settings.capabilities.IMicroProfileRegistrationConfiguration;

import static org.eclipse.lsp4mp.settings.capabilities.ServerCapabilitiesConstants.TEXT_DOCUMENT_FORMATTING;
import static org.eclipse.lsp4mp.settings.capabilities.ServerCapabilitiesConstants.TEXT_DOCUMENT_RANGE_FORMATTING;

/**
 * Helidon LS Registration configuration
 *
 */
public class HelidonRegistrationConfiguration implements IMicroProfileRegistrationConfiguration {

	@Override
	public void configure(Registration registration) {
		switch (registration.getMethod()) {
		case TEXT_DOCUMENT_FORMATTING:
		case TEXT_DOCUMENT_RANGE_FORMATTING:
			// add "helidon-properties" as language document filter
			((TextDocumentRegistrationOptions) registration.getRegisterOptions()).getDocumentSelector()
					.add(new DocumentFilter("helidon-properties", null, null));
			break;
		default:
			break;

		}

	}

}
