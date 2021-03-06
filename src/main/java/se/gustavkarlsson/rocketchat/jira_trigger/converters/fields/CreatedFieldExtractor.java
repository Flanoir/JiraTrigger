package se.gustavkarlsson.rocketchat.jira_trigger.converters.fields;

import com.atlassian.jira.rest.client.api.domain.Issue;
import org.joda.time.format.DateTimeFormatter;

import static org.apache.commons.lang3.Validate.notNull;

public class CreatedFieldExtractor extends AbstractFieldExtractor {

	private final DateTimeFormatter dateFormatter;

	public CreatedFieldExtractor(DateTimeFormatter dateTimeFormatter) {
		this.dateFormatter = notNull(dateTimeFormatter);
	}

	@Override
	protected String getTitle() {
		return "Created";
	}

	@Override
	protected String getValue(Issue issue) {
		return dateFormatter.print(issue.getCreationDate());
	}

	@Override
	protected boolean isShortValue() {
		return true;
	}
}
