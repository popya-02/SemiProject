if(typeof window.nhn=='undefined') window.nhn = {};
if (!nhn.husky) nhn.husky = {};

/**
 * @fileOverview This file contains application creation helper function, which would load up an HTML(Skin) file and then execute a specified create function.
 * @name HuskyEZCreator.js
 */
nhn.husky.EZCreator = new (function(){
    this.nBlockerCount = 0;

    this.createInIFrame = function(htOptions) {
        var oAppRef = htOptions.oAppRef || [];
        var elPlaceHolder = typeof htOptions.elPlaceHolder === 'string' ? document.getElementById(htOptions.elPlaceHolder) : htOptions.elPlaceHolder;
        var sSkinURI = htOptions.sSkinURI;
        var fCreator = htOptions.fCreator;
        var fOnAppLoad = htOptions.fOnAppLoad;
        var bUseBlocker = htOptions.bUseBlocker;
        var htParams = htOptions.htParams || null;

        if (!elPlaceHolder) {
            alert("Invalid placeholder element or ID: " + htOptions.elPlaceHolder);
            return;
        }

        if (bUseBlocker) {
            this.showBlocker();
        }

        var elIFrame;
        try {
            elIFrame = document.createElement('iframe');
            elIFrame.setAttribute('frameborder', '0');
            elIFrame.setAttribute('scrolling', 'no');
            elIFrame.style.width = '1px';
            elIFrame.style.height = '1px';
            elPlaceHolder.parentNode.insertBefore(elIFrame, elPlaceHolder.nextSibling);

            var attachEvent = function(elNode, sEvent, fHandler) {
                if (elNode.addEventListener) {
                    elNode.addEventListener(sEvent, fHandler, false);
                } else {
                    elNode.attachEvent('on' + sEvent, fHandler);
                }
            };

            attachEvent(elIFrame, 'load', function() {
                try {
                    var iframeWindow = elIFrame.contentWindow || elIFrame.contentDocument.defaultView;
                    if (!iframeWindow) {
                        throw new Error('Failed to access iframe window');
                    }
                    fCreator = iframeWindow[fCreator] || iframeWindow.createSEditor2;

                    var nEditorWidth = iframeWindow.document.body.scrollWidth || '500px';
                    var nEditorHeight = iframeWindow.document.body.scrollHeight + 12;
                    elIFrame.style.width = '100%';
                    elIFrame.style.height = nEditorHeight + 'px';
                    iframeWindow.document.body.style.margin = '0';

                    var oApp = fCreator(elPlaceHolder, htParams);

                    oApp.elPlaceHolder = elPlaceHolder;

                    oAppRef.push(oApp);
                    if (!oAppRef.getById) {
                        oAppRef.getById = {};
                    }

                    if (elPlaceHolder.id) {
                        oAppRef.getById[elPlaceHolder.id] = oApp;
                    }

                    oApp.run({ fnOnAppReady: fOnAppLoad });

                    nhn.husky.EZCreator.hideBlocker();
                } catch (e) {
                    nhn.husky.EZCreator.hideBlocker(true);
                    elIFrame.style.border = '5px solid red';
                    elIFrame.style.width = '500px';
                    elIFrame.style.height = '500px';
                    alert('Failed to access ' + sSkinURI + '\n' + e.message);
                }
            });

            elIFrame.src = sSkinURI;
            this.elIFrame = elIFrame;
        } catch (e) {
            alert('Error creating iframe: ' + e.message);
        }
    };

    this.showBlocker = function() {
        if (this.nBlockerCount < 1) {
            var elBlocker = document.createElement('div');
            elBlocker.style.position = 'absolute';
            elBlocker.style.top = 0;
            elBlocker.style.left = 0;
            elBlocker.style.backgroundColor = '#FFFFFF';
            elBlocker.style.width = '100%';
            elBlocker.style.height = Math.max(document.body.scrollHeight, document.body.clientHeight) + 'px';

            document.body.appendChild(elBlocker);

            nhn.husky.EZCreator.elBlocker = elBlocker;
        }

        this.nBlockerCount++;
    };

    this.hideBlocker = function(bForce) {
        if (!bForce) {
            if (--this.nBlockerCount > 0) return;
        }

        this.nBlockerCount = 0;

        if (nhn.husky.EZCreator.elBlocker) {
            nhn.husky.EZCreator.elBlocker.style.display = 'none';
        }
    };
})();
