package com.bugreserve.manage.model.issue;

public enum WorkflowStep {
    open,
    inProgress,
    pendingCodeReview,
    failedCodeReview,
    resolved,
    inValidation,
    closed
}
