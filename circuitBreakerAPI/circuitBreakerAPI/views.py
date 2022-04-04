from django.http import HttpResponse
import json
from random import random as rand

from matplotlib.font_manager import json_dump

_probablity_cdf = dict()
_probablity_cdf['video'] = [0.2,0.6,1.0]
_probablity_cdf['audio'] = [0.4,0.8,1.0]
_probablity_cdf['chat'] = [0.6,0.9,1.0]

def home(req):
    return HttpResponse("3 features exist: video, audio, chat.")

def videoStream(req):
    _res = {}
    _res['quality'] = generateQuality('video')
    return HttpResponse(json.dumps(_res))

def audioStream(req):
    _res = {}
    _res['quality'] = generateQuality('audio')
    return HttpResponse(json.dumps(_res))

def chatMsg(req):
    _res = {}
    _res['quality'] = generateQuality('chat')
    return HttpResponse(json.dumps(_res))
    
def generateQuality(stream_type):
    random_var = rand()
    if(random_var <= _probablity_cdf[stream_type][0]):
        return 1
    elif(_probablity_cdf[stream_type][0] < random_var <= _probablity_cdf[stream_type][1]):
        return 2
    else:
        return 3