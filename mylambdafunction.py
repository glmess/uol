#Lambda fuction handler


import lambdainit
import lambdalogging

LOG = lambdalogging.getLogger(__name__)


def handler(event, context):
	#Log every incoming event
	LOG.info('Received event: %s', event)