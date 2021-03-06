package no.difi.jenkins.pipeline.stages

import no.difi.jenkins.pipeline.Jira

Jira jira

void script() {
    jira.readyForCodeReview()
    if (env.startVerification == 'true') {
        jira.startVerification()
    }
    jira.waitUntilVerificationIsStarted()
}

void failureScript() {
    cleanup()
    jira.addFailureComment()
}

void abortedScript() {
    cleanup()
    jira.addAbortedComment()
}

private void cleanup() {
    jira.resumeWork()
}