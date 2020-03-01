import numpy
import cv2
import math

cameraMatrix = numpy.array([  [1376.46033, 0, 358.073269],  [0, 3184.99481, 585.581111],  [0, 0, 1]  ])
distortionMatrix = numpy.array([[0.561113196, -6.99479935, 0.144599516, 0.0516362516, 76.0754132]])

target_height = 89.75
camera_height = 29
tilt_angle = math.radians(15)

def get_values(center):
    center_np = numpy.array([[[float(center[0]), float(center[1])]]])
    out_pt = cv2.undistortPoints(center_np, cameraMatrix, distortionMatrix, P=cameraMatrix)

    undist_center = out_pt[0, 0]
    
    x_prime = (undist_center[0] - cameraMatrix[0, 2]) / cameraMatrix[0, 0]
    y_prime = -(undist_center[1] - cameraMatrix[1, 2]) / cameraMatrix[1, 1]

    ax = math.atan2(x_prime, 1.0)
    ay = math.atan2(y_prime * math.cos(ax), 1.0)
    d = (target_height - camera_height) / math.tan(tilt_angle + ay)

    ax = math.degrees(ax)
    ay = math.degrees(ay)
    d /= 12
    return ax, ay, d

