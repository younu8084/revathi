package bambooPlans;
import com.atlassian.bamboo.specs.api.BambooSpec;
import com.atlassian.bamboo.specs.api.builders.BambooKey;
import com.atlassian.bamboo.specs.api.builders.BambooOid;
import com.atlassian.bamboo.specs.api.builders.credentials.SharedCredentialsIdentifier;
import com.atlassian.bamboo.specs.api.builders.permission.PermissionType;
import com.atlassian.bamboo.specs.api.builders.permission.Permissions;
import com.atlassian.bamboo.specs.api.builders.permission.PlanPermissions;
import com.atlassian.bamboo.specs.api.builders.plan.Job;
import com.atlassian.bamboo.specs.api.builders.plan.Plan;
import com.atlassian.bamboo.specs.api.builders.plan.PlanIdentifier;
import com.atlassian.bamboo.specs.api.builders.plan.Stage;
import com.atlassian.bamboo.specs.api.builders.plan.branches.BranchCleanup;
import com.atlassian.bamboo.specs.api.builders.plan.branches.PlanBranchManagement;
import com.atlassian.bamboo.specs.api.builders.plan.configuration.AllOtherPluginsConfiguration;
import com.atlassian.bamboo.specs.api.builders.plan.configuration.ConcurrentBuilds;
import com.atlassian.bamboo.specs.api.builders.plan.dependencies.Dependencies;
import com.atlassian.bamboo.specs.api.builders.plan.dependencies.DependenciesConfiguration;
import com.atlassian.bamboo.specs.api.builders.project.Project;
import com.atlassian.bamboo.specs.api.model.BambooKeyProperties;
import com.atlassian.bamboo.specs.api.model.BambooOidProperties;
import com.atlassian.bamboo.specs.api.model.plan.JobProperties;
import com.atlassian.bamboo.specs.api.model.plan.PlanProperties;
import com.atlassian.bamboo.specs.api.model.plan.StageProperties;
import com.atlassian.bamboo.specs.api.model.plan.branches.PlanBranchManagementProperties;
import com.atlassian.bamboo.specs.api.model.project.ProjectProperties;
import com.atlassian.bamboo.specs.builders.repository.git.GitRepository;
import com.atlassian.bamboo.specs.builders.task.CheckoutItem;
import com.atlassian.bamboo.specs.builders.task.MavenTask;
import com.atlassian.bamboo.specs.builders.task.ScriptTask;
import com.atlassian.bamboo.specs.builders.task.VcsCheckoutTask;
import com.atlassian.bamboo.specs.builders.trigger.RepositoryPollingTrigger;
import com.atlassian.bamboo.specs.model.task.MavenTaskProperties;
import com.atlassian.bamboo.specs.model.task.VcsCheckoutTaskProperties;
import com.atlassian.bamboo.specs.model.trigger.RepositoryPollingTriggerProperties;
import com.atlassian.bamboo.specs.util.BambooServer;
import com.atlassian.bamboo.specs.util.MapBuilder;



/**

 * Plan configuration for Bamboo.

 * Learn more on: <a href="https://confluence.atlassian.com/display/BAMBOO/Bamboo+Specs">https://confluence.atlassian.com/display/BAMBOO/Bamboo+Specs</a>

 */

@BambooSpec

public class PlanSpec {



    /**

     * Run main to publish plan on Bamboo

     */

    public static void main(final String[] args) throws Exception {

        //By default credentials are read from the '.credentials' file.

        BambooServer bambooServer = new BambooServer("http://18.220.143.53:8085");



        Plan plan = new PlanSpec().createPlan();



        bambooServer.publish(plan);

    }



    Project project() {

        return new Project()

                .name("PROJECT")

                .key("PR");

    }



    Plan createPlan() {

    return new Plan(

            project(),

            "bamboo-plans", "BP")

            .description("This plan updates Bamboo Plans")

            );





	}
