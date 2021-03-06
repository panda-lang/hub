webpackHotUpdate_N_E("pages/index",{

/***/ "./src/components/layout/Header.js":
/*!*****************************************!*\
  !*** ./src/components/layout/Header.js ***!
  \*****************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* WEBPACK VAR INJECTION */(function(module) {/* harmony import */ var J_Java_Spring_hub_hub_frontend_node_modules_babel_runtime_helpers_esm_defineProperty__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/defineProperty */ "./node_modules/@babel/runtime/helpers/esm/defineProperty.js");
/* harmony import */ var react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! react/jsx-dev-runtime */ "./node_modules/react/jsx-dev-runtime.js");
/* harmony import */ var react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1___default = /*#__PURE__*/__webpack_require__.n(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__);
/* harmony import */ var _chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @chakra-ui/react */ "./node_modules/@chakra-ui/react/dist/esm/index.js");
/* harmony import */ var components_layout_Container__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! components/layout/Container */ "./src/components/layout/Container.js");
/* harmony import */ var react_icons_fa__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! react-icons/fa */ "./node_modules/react-icons/fa/index.esm.js");
/* harmony import */ var react_icons_md__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! react-icons/md */ "./node_modules/react-icons/md/index.esm.js");
/* harmony import */ var components_layout_ThemeSwitch__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! components/layout/ThemeSwitch */ "./src/components/layout/ThemeSwitch.js");
/* harmony import */ var components_AuthProvider__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! components/AuthProvider */ "./src/components/AuthProvider.js");



var _jsxFileName = "J:\\Java\\Spring\\hub\\hub-frontend\\src\\components\\layout\\Header.js",
    _this = undefined,
    _s = $RefreshSig$(),
    _s2 = $RefreshSig$(),
    _s3 = $RefreshSig$();

function ownKeys(object, enumerableOnly) { var keys = Object.keys(object); if (Object.getOwnPropertySymbols) { var symbols = Object.getOwnPropertySymbols(object); if (enumerableOnly) symbols = symbols.filter(function (sym) { return Object.getOwnPropertyDescriptor(object, sym).enumerable; }); keys.push.apply(keys, symbols); } return keys; }

function _objectSpread(target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i] != null ? arguments[i] : {}; if (i % 2) { ownKeys(Object(source), true).forEach(function (key) { Object(J_Java_Spring_hub_hub_frontend_node_modules_babel_runtime_helpers_esm_defineProperty__WEBPACK_IMPORTED_MODULE_0__["default"])(target, key, source[key]); }); } else if (Object.getOwnPropertyDescriptors) { Object.defineProperties(target, Object.getOwnPropertyDescriptors(source)); } else { ownKeys(Object(source)).forEach(function (key) { Object.defineProperty(target, key, Object.getOwnPropertyDescriptor(source, key)); }); } } return target; }








var Header = function Header(props) {
  _s();

  var bgColor = Object(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["useColorModeValue"])('gray.50', 'gray.900');
  var color = Object(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["useColorModeValue"])('black', 'white');
  return /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(components_layout_Container__WEBPACK_IMPORTED_MODULE_3__["Container"], _objectSpread(_objectSpread({
    zIndex: "1",
    height: {
      sm: '4.5rem',
      base: 'auto'
    },
    bg: bgColor,
    color: color,
    shadow: "sm",
    paddingX: "37px"
  }, props), {}, {
    children: /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(components_layout_Container__WEBPACK_IMPORTED_MODULE_3__["Content"], {
      flexDirection: {
        sm: 'row',
        base: 'column'
      },
      justifyContent: "space-between",
      alignItems: "center",
      children: [/*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Box"], {
        width: {
          sm: '100px',
          base: 'auto'
        },
        paddingY: {
          sm: '0px',
          base: '7px'
        },
        children: /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Link"], {
          href: "/",
          _focus: {
            outline: 0
          },
          children: /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Heading"], {
            fontSize: "1.5rem",
            paddingRight: "0px",
            children: "Hub"
          }, void 0, false, {
            fileName: _jsxFileName,
            lineNumber: 47,
            columnNumber: 13
          }, _this)
        }, void 0, false, {
          fileName: _jsxFileName,
          lineNumber: 46,
          columnNumber: 11
        }, _this)
      }, void 0, false, {
        fileName: _jsxFileName,
        lineNumber: 42,
        columnNumber: 9
      }, _this), /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(Navigation, {
        paddingY: {
          sm: '0px',
          base: '7px'
        }
      }, void 0, false, {
        fileName: _jsxFileName,
        lineNumber: 52,
        columnNumber: 9
      }, _this), /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(Profile, {
        paddingY: {
          sm: '0px',
          base: '7px'
        }
      }, void 0, false, {
        fileName: _jsxFileName,
        lineNumber: 53,
        columnNumber: 9
      }, _this)]
    }, void 0, true, {
      fileName: _jsxFileName,
      lineNumber: 37,
      columnNumber: 7
    }, _this)
  }), void 0, false, {
    fileName: _jsxFileName,
    lineNumber: 28,
    columnNumber: 5
  }, _this);
};

_s(Header, "GxINmYQjSw+rm7TrtZAlo2dz7DQ=", false, function () {
  return [_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["useColorModeValue"], _chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["useColorModeValue"]];
});

_c = Header;

var Navigation = function Navigation(props) {
  return /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Flex"], _objectSpread(_objectSpread({}, props), {}, {
    children: [/*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(NavigationItem, {
      label: "About",
      href: "/about"
    }, void 0, false, {
      fileName: _jsxFileName,
      lineNumber: 62,
      columnNumber: 7
    }, _this), /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(NavigationItem, {
      label: "Docs",
      href: "/docs"
    }, void 0, false, {
      fileName: _jsxFileName,
      lineNumber: 63,
      columnNumber: 7
    }, _this), /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(NavigationItem, {
      label: "Explore",
      href: "/explore"
    }, void 0, false, {
      fileName: _jsxFileName,
      lineNumber: 64,
      columnNumber: 7
    }, _this), /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(NavigationItem, {
      label: "Support",
      href: "https://panda-lang.org/support/"
    }, void 0, false, {
      fileName: _jsxFileName,
      lineNumber: 65,
      columnNumber: 7
    }, _this)]
  }), void 0, true, {
    fileName: _jsxFileName,
    lineNumber: 61,
    columnNumber: 5
  }, _this);
};

_c2 = Navigation;

var NavigationItem = function NavigationItem(props) {
  return /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Link"], _objectSpread(_objectSpread({
    href: props.href,
    fontWeight: "bold",
    paddingX: "13px",
    _focus: {
      outline: 0
    }
  }, props), {}, {
    children: props.label
  }), void 0, false, {
    fileName: _jsxFileName,
    lineNumber: 72,
    columnNumber: 5
  }, _this);
};

_c3 = NavigationItem;

var Profile = function Profile(props) {
  _s2();

  var _useAuth = Object(components_AuthProvider__WEBPACK_IMPORTED_MODULE_7__["useAuth"])(),
      getJwt = _useAuth.getJwt;

  console.log('profile');
  return /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Flex"], _objectSpread(_objectSpread({
    alignItems: "center",
    display: {
      sm: 'flex',
      base: 'none'
    }
  }, props), {}, {
    children: getJwt() ? /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(ProfileMenu, {}, void 0, false, {
      fileName: _jsxFileName,
      lineNumber: 89,
      columnNumber: 20
    }, _this) : /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(Login, {}, void 0, false, {
      fileName: _jsxFileName,
      lineNumber: 89,
      columnNumber: 37
    }, _this)
  }), void 0, false, {
    fileName: _jsxFileName,
    lineNumber: 88,
    columnNumber: 5
  }, _this);
};

_s2(Profile, "BSxlt9l5nac89oJTjXT7xtNKQ4Y=", false, function () {
  return [components_AuthProvider__WEBPACK_IMPORTED_MODULE_7__["useAuth"]];
});

_c4 = Profile;

var Login = function Login(props) {
  return /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Link"], _objectSpread(_objectSpread({
    href: "http://localhost:8080/authorize/github"
  }, props), {}, {
    children: /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Flex"], {
      width: "100px",
      children: [/*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Text"], {
        children: "Sign In"
      }, void 0, false, {
        fileName: _jsxFileName,
        lineNumber: 98,
        columnNumber: 9
      }, _this), /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Text"], {
        marginTop: "4px",
        marginLeft: "7px",
        children: /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(react_icons_fa__WEBPACK_IMPORTED_MODULE_4__["FaGithub"], {
          fontSize: "1.15rem"
        }, void 0, false, {
          fileName: _jsxFileName,
          lineNumber: 100,
          columnNumber: 11
        }, _this)
      }, void 0, false, {
        fileName: _jsxFileName,
        lineNumber: 99,
        columnNumber: 9
      }, _this)]
    }, void 0, true, {
      fileName: _jsxFileName,
      lineNumber: 97,
      columnNumber: 7
    }, _this)
  }), void 0, false, {
    fileName: _jsxFileName,
    lineNumber: 96,
    columnNumber: 5
  }, _this);
};

_c5 = Login;

var ProfileMenu = function ProfileMenu(props) {
  _s3();

  var _useAuth2 = Object(components_AuthProvider__WEBPACK_IMPORTED_MODULE_7__["useAuth"])(),
      user = _useAuth2.user,
      handleLogout = _useAuth2.handleLogout;

  var profile = user || {};
  return /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Flex"], {
    children: /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Menu"], {
      children: [/*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["MenuButton"], {
        as: _chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Button"],
        rightIcon: /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(react_icons_md__WEBPACK_IMPORTED_MODULE_5__["MdArrowDropDown"], {}, void 0, false, {
          fileName: _jsxFileName,
          lineNumber: 114,
          columnNumber: 44
        }, _this),
        children: profile.username
      }, void 0, false, {
        fileName: _jsxFileName,
        lineNumber: 114,
        columnNumber: 9
      }, _this), /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["MenuList"], {
        children: [/*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["MenuDivider"], {}, void 0, false, {
          fileName: _jsxFileName,
          lineNumber: 118,
          columnNumber: 11
        }, _this), /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Box"], {
          paddingX: "12px",
          children: ["Dark mode", /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(components_layout_ThemeSwitch__WEBPACK_IMPORTED_MODULE_6__["default"], {
            marginX: "7px"
          }, void 0, false, {
            fileName: _jsxFileName,
            lineNumber: 121,
            columnNumber: 13
          }, _this)]
        }, void 0, true, {
          fileName: _jsxFileName,
          lineNumber: 119,
          columnNumber: 11
        }, _this), /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["MenuDivider"], {}, void 0, false, {
          fileName: _jsxFileName,
          lineNumber: 123,
          columnNumber: 11
        }, _this), /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["MenuGroup"], {
          children: [/*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["MenuItem"], {
            children: "My profile"
          }, void 0, false, {
            fileName: _jsxFileName,
            lineNumber: 125,
            columnNumber: 13
          }, _this), /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["MenuItem"], {
            children: "Settings "
          }, void 0, false, {
            fileName: _jsxFileName,
            lineNumber: 126,
            columnNumber: 13
          }, _this), /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["MenuItem"], {
            onClick: handleLogout,
            children: "Logout"
          }, void 0, false, {
            fileName: _jsxFileName,
            lineNumber: 127,
            columnNumber: 13
          }, _this)]
        }, void 0, true, {
          fileName: _jsxFileName,
          lineNumber: 124,
          columnNumber: 11
        }, _this)]
      }, void 0, true, {
        fileName: _jsxFileName,
        lineNumber: 117,
        columnNumber: 9
      }, _this)]
    }, void 0, true, {
      fileName: _jsxFileName,
      lineNumber: 113,
      columnNumber: 7
    }, _this)
  }, void 0, false, {
    fileName: _jsxFileName,
    lineNumber: 112,
    columnNumber: 5
  }, _this);
};

_s3(ProfileMenu, "mSW+RoajZBiJZe2sByCSxGQKiOI=", false, function () {
  return [components_AuthProvider__WEBPACK_IMPORTED_MODULE_7__["useAuth"]];
});

_c6 = ProfileMenu;
/* harmony default export */ __webpack_exports__["default"] = (Header);

var _c, _c2, _c3, _c4, _c5, _c6;

$RefreshReg$(_c, "Header");
$RefreshReg$(_c2, "Navigation");
$RefreshReg$(_c3, "NavigationItem");
$RefreshReg$(_c4, "Profile");
$RefreshReg$(_c5, "Login");
$RefreshReg$(_c6, "ProfileMenu");

;
    var _a, _b;
    // Legacy CSS implementations will `eval` browser code in a Node.js context
    // to extract CSS. For backwards compatibility, we need to check we're in a
    // browser context before continuing.
    if (typeof self !== 'undefined' &&
        // AMP / No-JS mode does not inject these helpers:
        '$RefreshHelpers$' in self) {
        var currentExports = module.__proto__.exports;
        var prevExports = (_b = (_a = module.hot.data) === null || _a === void 0 ? void 0 : _a.prevExports) !== null && _b !== void 0 ? _b : null;
        // This cannot happen in MainTemplate because the exports mismatch between
        // templating and execution.
        self.$RefreshHelpers$.registerExportsForReactRefresh(currentExports, module.i);
        // A module can be accepted automatically based on its exports, e.g. when
        // it is a Refresh Boundary.
        if (self.$RefreshHelpers$.isReactRefreshBoundary(currentExports)) {
            // Save the previous exports on update so we can compare the boundary
            // signatures.
            module.hot.dispose(function (data) {
                data.prevExports = currentExports;
            });
            // Unconditionally accept an update to this module, we'll check if it's
            // still a Refresh Boundary later.
            module.hot.accept();
            // This field is set when the previous version of this module was a
            // Refresh Boundary, letting us know we need to check for invalidation or
            // enqueue an update.
            if (prevExports !== null) {
                // A boundary can become ineligible if its exports are incompatible
                // with the previous exports.
                //
                // For example, if you add/remove/change exports, we'll want to
                // re-execute the importing modules, and force those components to
                // re-render. Similarly, if you convert a class component to a
                // function, we want to invalidate the boundary.
                if (self.$RefreshHelpers$.shouldInvalidateReactRefreshBoundary(prevExports, currentExports)) {
                    module.hot.invalidate();
                }
                else {
                    self.$RefreshHelpers$.scheduleUpdate();
                }
            }
        }
        else {
            // Since we just executed the code for the module, it's possible that the
            // new exports made it ineligible for being a boundary.
            // We only care about the case when we were _previously_ a boundary,
            // because we already accepted this update (accidental side effect).
            var isNoLongerABoundary = prevExports !== null;
            if (isNoLongerABoundary) {
                module.hot.invalidate();
            }
        }
    }

/* WEBPACK VAR INJECTION */}.call(this, __webpack_require__(/*! ./../../../node_modules/next/dist/compiled/webpack/harmony-module.js */ "./node_modules/next/dist/compiled/webpack/harmony-module.js")(module)))

/***/ })

})
//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly9fTl9FLy4vc3JjL2NvbXBvbmVudHMvbGF5b3V0L0hlYWRlci5qcyJdLCJuYW1lcyI6WyJIZWFkZXIiLCJwcm9wcyIsImJnQ29sb3IiLCJ1c2VDb2xvck1vZGVWYWx1ZSIsImNvbG9yIiwic20iLCJiYXNlIiwib3V0bGluZSIsIk5hdmlnYXRpb24iLCJOYXZpZ2F0aW9uSXRlbSIsImhyZWYiLCJsYWJlbCIsIlByb2ZpbGUiLCJ1c2VBdXRoIiwiZ2V0Snd0IiwiY29uc29sZSIsImxvZyIsIkxvZ2luIiwiUHJvZmlsZU1lbnUiLCJ1c2VyIiwiaGFuZGxlTG9nb3V0IiwicHJvZmlsZSIsIkJ1dHRvbiIsInVzZXJuYW1lIl0sIm1hcHBpbmdzIjoiOzs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7QUFBQTtBQWVBO0FBQ0E7QUFDQTtBQUVBO0FBQ0E7O0FBRUEsSUFBTUEsTUFBTSxHQUFHLFNBQVRBLE1BQVMsQ0FBQ0MsS0FBRCxFQUFXO0FBQUE7O0FBQ3hCLE1BQU1DLE9BQU8sR0FBR0MsMEVBQWlCLENBQUMsU0FBRCxFQUFZLFVBQVosQ0FBakM7QUFDQSxNQUFNQyxLQUFLLEdBQUdELDBFQUFpQixDQUFDLE9BQUQsRUFBVSxPQUFWLENBQS9CO0FBRUEsc0JBQ0UscUVBQUMscUVBQUQ7QUFDRSxVQUFNLEVBQUMsR0FEVDtBQUVFLFVBQU0sRUFBRTtBQUFFRSxRQUFFLEVBQUUsUUFBTjtBQUFnQkMsVUFBSSxFQUFFO0FBQXRCLEtBRlY7QUFHRSxNQUFFLEVBQUVKLE9BSE47QUFJRSxTQUFLLEVBQUVFLEtBSlQ7QUFLRSxVQUFNLEVBQUMsSUFMVDtBQU1FLFlBQVEsRUFBQztBQU5YLEtBT01ILEtBUE47QUFBQSwyQkFTRSxxRUFBQyxtRUFBRDtBQUNFLG1CQUFhLEVBQUU7QUFBRUksVUFBRSxFQUFFLEtBQU47QUFBYUMsWUFBSSxFQUFFO0FBQW5CLE9BRGpCO0FBRUUsb0JBQWMsRUFBQyxlQUZqQjtBQUdFLGdCQUFVLEVBQUMsUUFIYjtB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LGVBREYsZUFJRSxxRUFBQyx5REFBRDtBQUFBLGdDQUNFLHFFQUFDLDREQUFEO0FBQUE7QUFBQTtBQUFBO0FBQUEsaUJBREYsZUFFRSxxRUFBQyxvREFBRDtBQUFLLGtCQUFRLEVBQUMsTUFBZDtBQUFBLCtDQUVFLHFFQUFDLHFFQUFEO0FBQWEsbUJBQU8sRUFBQztBQUFyQjtBQUFBO0FBQUE7QUFBQTtBQUFBLG1CQUZGO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQSxpQkFGRixlQU1FLHFFQUFDLDREQUFEO0FBQUE7QUFBQTtBQUFBO0FBQUEsaUJBTkYsZUFPRSxxRUFBQywwREFBRDtBQUFBLGtDQUNFLHFFQUFDLHlEQUFEO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBLG1CQURGLGVBRUUscUVBQUMseURBQUQ7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUEsbUJBRkYsZUFHRSxxRUFBQyx5REFBRDtBQUFVLG1CQUFPLEVBQUVILFlBQW5CO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBLG1CQUhGO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQSxpQkFQRjtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUEsZUFKRjtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFERjtBQUFBO0FBQUE7QUFBQTtBQUFBLFdBREY7QUFzQkQsQ0ExQkQ7O0lBQU1GLFc7VUFDMkJMLCtEOzs7TUFEM0JLLFc7QUE0QlNsQixxRUFBZiIsImZpbGUiOiJzdGF0aWMvd2VicGFjay9wYWdlcy9pbmRleC5hZWQyMDRiMDQxYzg5MzllYmJjOS5ob3QtdXBkYXRlLmpzIiwic291cmNlc0NvbnRlbnQiOlsiaW1wb3J0IHtcbiAgRmxleCxcbiAgQm94LFxuICBIZWFkaW5nLFxuICBMaW5rLFxuICBCdXR0b24sXG4gIFRleHQsXG4gIE1lbnUsXG4gIE1lbnVCdXR0b24sXG4gIE1lbnVJdGVtLFxuICBNZW51R3JvdXAsXG4gIE1lbnVMaXN0LFxuICBNZW51RGl2aWRlcixcbiAgdXNlQ29sb3JNb2RlVmFsdWUsXG59IGZyb20gJ0BjaGFrcmEtdWkvcmVhY3QnXG5pbXBvcnQgeyBDb250YWluZXIsIENvbnRlbnQgfSBmcm9tICdjb21wb25lbnRzL2xheW91dC9Db250YWluZXInXG5pbXBvcnQgeyBGYUdpdGh1YiB9IGZyb20gJ3JlYWN0LWljb25zL2ZhJ1xuaW1wb3J0IHsgTWRBcnJvd0Ryb3BEb3duIH0gZnJvbSAncmVhY3QtaWNvbnMvbWQnXG5cbmltcG9ydCBUaGVtZVN3aXRjaCBmcm9tICdjb21wb25lbnRzL2xheW91dC9UaGVtZVN3aXRjaCdcbmltcG9ydCB7IHVzZUF1dGggfSBmcm9tICdjb21wb25lbnRzL0F1dGhQcm92aWRlcidcblxuY29uc3QgSGVhZGVyID0gKHByb3BzKSA9PiB7XG4gIGNvbnN0IGJnQ29sb3IgPSB1c2VDb2xvck1vZGVWYWx1ZSgnZ3JheS41MCcsICdncmF5LjkwMCcpXG4gIGNvbnN0IGNvbG9yID0gdXNlQ29sb3JNb2RlVmFsdWUoJ2JsYWNrJywgJ3doaXRlJylcblxuICByZXR1cm4gKFxuICAgIDxDb250YWluZXJcbiAgICAgIHpJbmRleD1cIjFcIlxuICAgICAgaGVpZ2h0PXt7IHNtOiAnNC41cmVtJywgYmFzZTogJ2F1dG8nIH19XG4gICAgICBiZz17YmdDb2xvcn1cbiAgICAgIGNvbG9yPXtjb2xvcn1cbiAgICAgIHNoYWRvdz1cInNtXCJcbiAgICAgIHBhZGRpbmdYPVwiMzdweFwiXG4gICAgICB7Li4ucHJvcHN9XG4gICAgPlxuICAgICAgPENvbnRlbnRcbiAgICAgICAgZmxleERpcmVjdGlvbj17eyBzbTogJ3JvdycsIGJhc2U6ICdjb2x1bW4nIH19XG4gICAgICAgIGp1c3RpZnlDb250ZW50PVwic3BhY2UtYmV0d2VlblwiXG4gICAgICAgIGFsaWduSXRlbXM9XCJjZW50ZXJcIlxuICAgICAgPlxuICAgICAgICA8Qm94XG4gICAgICAgICAgd2lkdGg9e3sgc206ICcxMDBweCcsIGJhc2U6ICdhdXRvJyB9fVxuICAgICAgICAgIHBhZGRpbmdZPXt7IHNtOiAnMHB4JywgYmFzZTogJzdweCcgfX1cbiAgICAgICAgPlxuICAgICAgICAgIDxMaW5rIGhyZWY9XCIvXCIgX2ZvY3VzPXt7IG91dGxpbmU6IDAgfX0+XG4gICAgICAgICAgICA8SGVhZGluZyBmb250U2l6ZT1cIjEuNXJlbVwiIHBhZGRpbmdSaWdodD1cIjBweFwiPlxuICAgICAgICAgICAgICBIdWJcbiAgICAgICAgICAgIDwvSGVhZGluZz5cbiAgICAgICAgICA8L0xpbms+XG4gICAgICAgIDwvQm94PlxuICAgICAgICA8TmF2aWdhdGlvbiBwYWRkaW5nWT17eyBzbTogJzBweCcsIGJhc2U6ICc3cHgnIH19IC8+XG4gICAgICAgIDxQcm9maWxlIHBhZGRpbmdZPXt7IHNtOiAnMHB4JywgYmFzZTogJzdweCcgfX0gLz5cbiAgICAgIDwvQ29udGVudD5cbiAgICA8L0NvbnRhaW5lcj5cbiAgKVxufVxuXG5jb25zdCBOYXZpZ2F0aW9uID0gKHByb3BzKSA9PiB7XG4gIHJldHVybiAoXG4gICAgPEZsZXggey4uLnByb3BzfT5cbiAgICAgIDxOYXZpZ2F0aW9uSXRlbSBsYWJlbD1cIkFib3V0XCIgaHJlZj1cIi9hYm91dFwiIC8+XG4gICAgICA8TmF2aWdhdGlvbkl0ZW0gbGFiZWw9XCJEb2NzXCIgaHJlZj1cIi9kb2NzXCIgLz5cbiAgICAgIDxOYXZpZ2F0aW9uSXRlbSBsYWJlbD1cIkV4cGxvcmVcIiBocmVmPVwiL2V4cGxvcmVcIiAvPlxuICAgICAgPE5hdmlnYXRpb25JdGVtIGxhYmVsPVwiU3VwcG9ydFwiIGhyZWY9XCJodHRwczovL3BhbmRhLWxhbmcub3JnL3N1cHBvcnQvXCIgLz5cbiAgICA8L0ZsZXg+XG4gIClcbn1cblxuY29uc3QgTmF2aWdhdGlvbkl0ZW0gPSAocHJvcHMpID0+IHtcbiAgcmV0dXJuIChcbiAgICA8TGlua1xuICAgICAgaHJlZj17cHJvcHMuaHJlZn1cbiAgICAgIGZvbnRXZWlnaHQ9XCJib2xkXCJcbiAgICAgIHBhZGRpbmdYPVwiMTNweFwiXG4gICAgICBfZm9jdXM9e3sgb3V0bGluZTogMCB9fVxuICAgICAgey4uLnByb3BzfVxuICAgID5cbiAgICAgIHtwcm9wcy5sYWJlbH1cbiAgICA8L0xpbms+XG4gIClcbn1cblxuY29uc3QgUHJvZmlsZSA9IChwcm9wcykgPT4ge1xuICBjb25zdCB7IGdldEp3dCB9ID0gdXNlQXV0aCgpXG4gIGNvbnNvbGUubG9nKCdwcm9maWxlJylcbiAgcmV0dXJuIChcbiAgICA8RmxleCBhbGlnbkl0ZW1zPVwiY2VudGVyXCIgZGlzcGxheT17eyBzbTogJ2ZsZXgnLCBiYXNlOiAnbm9uZScgfX0gey4uLnByb3BzfT5cbiAgICAgIHsgZ2V0Snd0KCkgPyA8UHJvZmlsZU1lbnUvPiA6IDxMb2dpbiAvPiB9XG4gICAgPC9GbGV4PlxuICApXG59XG5cbmNvbnN0IExvZ2luID0gKHByb3BzKSA9PiB7XG4gIHJldHVybiAoXG4gICAgPExpbmsgaHJlZj1cImh0dHA6Ly9sb2NhbGhvc3Q6ODA4MC9hdXRob3JpemUvZ2l0aHViXCIgey4uLnByb3BzfT5cbiAgICAgIDxGbGV4IHdpZHRoPVwiMTAwcHhcIj5cbiAgICAgICAgPFRleHQ+U2lnbiBJbjwvVGV4dD5cbiAgICAgICAgPFRleHQgbWFyZ2luVG9wPVwiNHB4XCIgbWFyZ2luTGVmdD1cIjdweFwiPlxuICAgICAgICAgIDxGYUdpdGh1YiBmb250U2l6ZT1cIjEuMTVyZW1cIiAvPlxuICAgICAgICA8L1RleHQ+XG4gICAgICA8L0ZsZXg+XG4gICAgPC9MaW5rPlxuICApXG59XG5cbmNvbnN0IFByb2ZpbGVNZW51ID0gKHByb3BzKSA9PiB7XG4gIGNvbnN0IHsgdXNlciwgaGFuZGxlTG9nb3V0IH0gPSB1c2VBdXRoKClcbiAgY29uc3QgcHJvZmlsZSA9IHVzZXIgfHwge31cblxuICByZXR1cm4gKFxuICAgIDxGbGV4PlxuICAgICAgPE1lbnU+XG4gICAgICAgIDxNZW51QnV0dG9uIGFzPXtCdXR0b259IHJpZ2h0SWNvbj17PE1kQXJyb3dEcm9wRG93biAvPn0+XG4gICAgICAgICAge3Byb2ZpbGUudXNlcm5hbWV9XG4gICAgICAgIDwvTWVudUJ1dHRvbj5cbiAgICAgICAgPE1lbnVMaXN0PlxuICAgICAgICAgIDxNZW51RGl2aWRlciAvPlxuICAgICAgICAgIDxCb3ggcGFkZGluZ1g9XCIxMnB4XCI+XG4gICAgICAgICAgICBEYXJrIG1vZGVcbiAgICAgICAgICAgIDxUaGVtZVN3aXRjaCBtYXJnaW5YPVwiN3B4XCIgLz5cbiAgICAgICAgICA8L0JveD5cbiAgICAgICAgICA8TWVudURpdmlkZXIgLz5cbiAgICAgICAgICA8TWVudUdyb3VwPlxuICAgICAgICAgICAgPE1lbnVJdGVtPk15IHByb2ZpbGU8L01lbnVJdGVtPlxuICAgICAgICAgICAgPE1lbnVJdGVtPlNldHRpbmdzIDwvTWVudUl0ZW0+XG4gICAgICAgICAgICA8TWVudUl0ZW0gb25DbGljaz17aGFuZGxlTG9nb3V0fT5Mb2dvdXQ8L01lbnVJdGVtPlxuICAgICAgICAgIDwvTWVudUdyb3VwPlxuICAgICAgICA8L01lbnVMaXN0PlxuICAgICAgPC9NZW51PlxuICAgIDwvRmxleD5cbiAgKVxufVxuXG5leHBvcnQgZGVmYXVsdCBIZWFkZXJcbiJdLCJzb3VyY2VSb290IjoiIn0=