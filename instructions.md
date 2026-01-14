# AEM Developer Technical Assessment

Welcome to the technical assessment for the AEM Developer role.

## Prerequisites
-   **Java 11** installed and configured.
-   **Maven 3.9.x** installed and configured.
-   IDE of your choice.

## Instructions

### 1. Setup
1.  Clone the repository to your local machine:
    ```bash
    git clone <repository-url>
    cd <repository-directory>
    ```
2.  Open the project in your IDE.

### 2. Branching
Create a new branch for your work. Please use the naming convention `candidate/<your-first-name>-<your-last-name>`.

```bash
git checkout -b candidate/your-name
```

### 3. Assessment Tasks

#### Task 1: Bug Fixes (Issue #3)
**Context:** The `Simple Greeting` component is currently broken. It is preventing the project from building, and the frontend rendering is incorrect.

**Your Goal:**
1.  Run `mvn clean install` to identify the build error.
2.  Fix the compilation issue in the `core` bundle.
3.  Deploy the code and test the component on a page.
4.  Identify and fix the issue where the greeting message is not displaying in the HTML.
5.  **Commit your changes** to your branch.

#### Task 2: Feature Enhancement (Issue #4)
**Context:** We want to enhance the greeting service to be time-aware.

**Your Goal:**
1.  Read the requirements for the "Time-Based Greeting" feature.
2.  Modify the `GreetingService` (Interface & Implementation) to return a greeting based on the current time of day (Morning/Afternoon/Evening).
3.  Update the Sling Model to utilize this new logic.
4.  Ensure the component displays the new format: `"{TimeBasedGreeting}, {Name}!"`.
5.  **Commit your changes** to your branch.

## Submission
Once completed, push your branch to the repository and notify the hiring manager.

Good luck!
